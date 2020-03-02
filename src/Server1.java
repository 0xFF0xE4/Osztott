import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

    /* 7. feladat innen: https://kitlei.web.elte.hu/segedanyagok/felev/2019-2020-tavasz/osztott/osztott-feladatok.html */

    public static void main(String[] args) throws IOException {

        String filename = args.length > 0 ? "src/numbers.txt" : "src/ports.txt";
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 12345;
        try (ServerSocket ss = new ServerSocket(port)) {
            Socket s = ss.accept();
            PrintWriter pw = new PrintWriter((s.getOutputStream()));
            try (Scanner fileReader = new Scanner(new File(filename))) {
                while (fileReader.hasNextInt()) {
                    pw.println(fileReader.nextInt());
                    pw.flush();
                }
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}