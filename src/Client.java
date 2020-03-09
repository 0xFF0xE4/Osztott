import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 12345;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        try (
                Socket s = new Socket(HOST, PORT);
                Scanner readStream = new Scanner(s.getInputStream());
                PrintWriter pw = new PrintWriter(s.getOutputStream())
        ) {
            Scanner readConsole = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = readConsole.nextLine();

            pw.println(name);
            pw.flush();
        } catch (Exception e) { e.printStackTrace();}
    }

}
