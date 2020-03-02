import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Client {
    private static final int PORT = 12345;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        try (
                Socket s = new Socket(HOST, PORT);
                Scanner sc = new Scanner(s.getInputStream());
                PrintWriter pw = new PrintWriter(s.getOutputStream())
        ) {
            PrintWriter fileWriter = new PrintWriter(new File("output.txt"));
            int sum = 0;
            while(sc.hasNextInt()) {
                int port = sc.nextInt();
                try (Socket s_inner = new Socket(HOST, port);
                     Scanner sc_inner = new Scanner(s_inner.getInputStream());
                 ) {
                    while (sc_inner.hasNextInt()) {
                        int increment = sc_inner.nextInt();
                        sum += increment;
                        fileWriter.println(sum);
                        fileWriter.flush();
                    }
                }
            }
        } catch (Exception e) { e.printStackTrace();}
    }

}
