import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 10000;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        try (
                Socket s = new Socket(HOST, PORT);
                Scanner sc = new Scanner(s.getInputStream());
                PrintWriter pw = new PrintWriter(s.getOutputStream());
        ) {
            pw.println(123);
            pw.println(456);
            pw.println(789);
            pw.flush();

        } catch (Exception e) { e.printStackTrace();}
    }
}
