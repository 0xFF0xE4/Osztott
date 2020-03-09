import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

    /* 8. feladat innen: https://kitlei.web.elte.hu/segedanyagok/felev/2019-2020-tavasz/osztott/osztott-feladatok.html */

    public static void main(String[] args) throws IOException {

        int port = 12345;
        try (ServerSocket ss = new ServerSocket(port)) {
            Socket sock_1 = ss.accept();
            Socket sock_2 = ss.accept();
            Scanner sc_1 = new Scanner(sock_1.getInputStream());
            Scanner sc_2 = new Scanner(sock_2.getInputStream());
            PrintWriter pw_1 = new PrintWriter(sock_1.getOutputStream());
            PrintWriter pw_2 = new PrintWriter(sock_2.getOutputStream());

            String name_1 = sc_1.nextLine();
            String name_2 = sc_2.nextLine();

            System.out.println("Names: " + name_1 + " and " + name_2);

            while(sc_1.hasNextLine()) {
                String message = sc_1.nextLine();
                pw_2.println(name_1 + ": " + message);
                pw_2.flush();
                if (sc_2.hasNextLine()) {
                    message = sc_2.nextLine();
                    pw_1.println(name_2 + ": " + message);
                    pw_1.flush();
                } else {
                    break;
                }
            }

        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}