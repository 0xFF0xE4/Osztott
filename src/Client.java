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
        File outputFile = new File("src/output.txt");
        try (
                Socket s = new Socket(HOST, PORT);
                Scanner sc = new Scanner(s.getInputStream());
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                Scanner fileReader = new Scanner(inputFile);
                PrintWriter fileWriter = new PrintWriter(outputFile)
        ) {
            while (fileReader.hasNextInt()) {
                int num = fileReader.nextInt();
                if (num == 0) break;
                pw.println(num);
            }
            pw.println(0);
            pw.flush();

            while(sc.hasNextInt()) {
                int num = sc.nextInt();
                fileWriter.println(num);
            }
            fileWriter.flush();

        } catch (Exception e) { e.printStackTrace();}
    }

}
