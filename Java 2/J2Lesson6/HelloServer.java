/**
 * Java. Level 2. Lesson 6. Networking
 * Class HelloServer: waiting and sending message to the client
 *
 * @author Sergey Iryupin
 * @version dated Jan 10, 2018
 */
import java.net.*;
import java.io.*;

class HelloServer {

    public static void main(String[] args) {
        new HelloServer();
    }

    HelloServer() {
        try (ServerSocket server = new ServerSocket(1024)) {
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Server started on IP " + ipAddress);
            while (true) {
                Socket socket = server.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println("Server from IP " + ipAddress + " says: Hello");
                System.out.println("Message sent to client.");
                writer.close();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}