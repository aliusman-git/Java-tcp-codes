import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws IOException {
        // Connect to server on localhost at port 9090
        Socket socket = new Socket("localhost", 9090);
        System.out.println("Connected to server!");
        
        // Setup input/output streams
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner in = new Scanner(socket.getInputStream());
        Scanner scanner = new Scanner(System.in);

        String message;
        while (true) {
            System.out.print("You: ");
            message = scanner.nextLine();

            // send to server
            out.println(message);

            // get reply from server
            if (in.hasNextLine()) {
                String response = in.nextLine();
                System.out.println("Server says: " + response);
            }

            // exit condition
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
        }

        socket.close();
        scanner.close();
        in.close();
    }
}
