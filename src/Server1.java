import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

    private static final int PORT = 10000;

    /* 3. feladat innen: https://kitlei.web.elte.hu/segedanyagok/felev/2019-2020-tavasz/osztott/osztott-feladatok.html */

    public static void main(String[] args) throws IOException {
        try (
                ServerSocket ss = new ServerSocket(PORT);
                Socket s = ss.accept();
                Scanner sc = new Scanner(s.getInputStream());
                PrintWriter pw = new PrintWriter(s.getOutputStream());
        ) {
            while(sc.hasNextInt()) {
                int n = Integer.parseInt(sc.nextLine());
                if (n == 0) break;
                pw.println(transformInt(n));
                pw.flush();
            }
        } catch (Exception e) { e.printStackTrace();}
    }

    private static int transformInt(int n) {
        return 2 * n + 1;
    }

}