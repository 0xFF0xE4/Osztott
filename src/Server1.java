import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

    private static final int PORT = 10000;

    /* 4. feladat innen: https://kitlei.web.elte.hu/segedanyagok/felev/2019-2020-tavasz/osztott/osztott-feladatok.html */

    public static void main(String[] args) throws IOException {
        try (
                ServerSocket ss = new ServerSocket(PORT);
                Socket s = ss.accept();
                Scanner sc = new Scanner(s.getInputStream());
                PrintWriter pw = new PrintWriter(s.getOutputStream());
        ) {
            if (sc.hasNext()) {
                String filename = "src/" + sc.next();
                try (Scanner fileReader = new Scanner(new File(filename))) {
                    while(fileReader.hasNextLine()) {
                        pw.println(fileReader.nextLine());
                    }
                } catch (Exception er) { er.printStackTrace(); }
            }
        } catch (Exception e) { e.printStackTrace();}
    }

    private static int transformInt(int n) {
        return 2 * n + 1;
    }

}