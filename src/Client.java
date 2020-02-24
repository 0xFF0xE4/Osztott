import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 10000;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/input.txt");
        try (
                Socket s = new Socket(HOST, PORT);
                Scanner sc = new Scanner(s.getInputStream());
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                Scanner fileReader = new Scanner(inputFile);
        ) {
            StringBuilder sb = new StringBuilder();
            while(fileReader.hasNextInt()) {
                pw.println(fileReader.nextInt());
                pw.flush();
                System.out.println(sc.nextInt());
            }

        } catch (Exception e) { e.printStackTrace();}
    }

}
