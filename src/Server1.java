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
            if (sc.hasNextLine()) {
                String line = sc.nextLine();
                pw.println(line);
                // TILOS!
                // System.exit(0);
                pw.flush();
            }

        } catch (Exception e) { /**/}

        // ss.close();
    }

}