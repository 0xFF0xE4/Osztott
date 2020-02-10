import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

    private static final int PORT = 10000;

    public static void main(String[] args) throws IOException {
        try (
                ServerSocket ss = new ServerSocket(PORT);
                Socket s = ss.accept();
                Scanner sc = new Scanner(s.getInputStream());
                PrintWriter pw = new PrintWriter(s.getOutputStream());
        ) {
            int sum = 0;
            while (sc.hasNextInt()) {
                int in = sc.nextInt();
                if (in == 0) {
                    pw.println(sum);
                    pw.flush();
                    sum = 0;
                } else {
                    sum += in;
                }
            }

        } catch (Exception e) { e.printStackTrace();}

        // ss.close();
    }

}