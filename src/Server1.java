import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.exit;

public class Server1 {

    private static int PORT = 10000;

    /* 3. feladat innen: https://kitlei.web.elte.hu/segedanyagok/felev/2019-2020-tavasz/osztott/osztott-feladatok.html */

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
//            System.out.println("ERROR: port number not specified!");
//            exit(1);
            PORT = 10000;
        } else {
            PORT = Integer.parseInt(args[0]);
        }
        try (
                ServerSocket ss = new ServerSocket(PORT);
                Socket s = ss.accept();
                Scanner sc = new Scanner(s.getInputStream());
                PrintWriter pw = new PrintWriter(s.getOutputStream());
        ) {
            while(sc.hasNextInt()) {
                int n = sc.nextInt();
                pw.println(transformInt(n));
                pw.flush();
            }
        } catch (Exception e) { e.printStackTrace();}
    }

    private static int transformInt(int n) {
        return 2 * n + 1;
    }

}