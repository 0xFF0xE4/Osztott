import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

    private static final int PORT = 10000;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(PORT);
        Socket s = ss.accept();
    }
}
