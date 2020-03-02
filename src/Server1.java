import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

    private static final int PORT = 10000;

    /* 4. feladat innen: https://kitlei.web.elte.hu/segedanyagok/felev/2019-2020-tavasz/osztott/osztott-feladatok.html */

    public static void main(String[] args) throws IOException {
        int count = 0;
        try (
                ServerSocket ss = new ServerSocket(PORT);
        ) {
            while (true) {
                Socket s = ss.accept();
                Scanner sc = new Scanner(s.getInputStream());
                PrintWriter pw = new PrintWriter(s.getOutputStream());

                pw.println("You are the client number " + ++count);
                pw.flush();
                s.close();
            }
        } catch (Exception e) { e.printStackTrace();}
    }

}