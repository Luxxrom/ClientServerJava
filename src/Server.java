import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {

        int count = 0;
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");

        while (true) {

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted " + (++count));

            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    clientSocket.getOutputStream()));
            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    clientSocket.getInputStream()));

            String request = reader.readLine();
            String response = "GET HTTP/1.1 200 OK\n\n";  // only for Browser
            response = response + "#" + count + ", your message length is " + request.length() + "\n";

//            writer.write("GET HTTP/1.1 200 OK\n\n" +
//                    "Content-type: text/html\n" +
//                    "<h2>Hello JAVA " + count + "</h2>\n");
            Thread.sleep(3000);
            writer.write(response);
            writer.flush();

            reader.close();
            writer.close();

            clientSocket.close();

            if (count == 30) break;
        }
//        serverSocket.close();
    }
}
