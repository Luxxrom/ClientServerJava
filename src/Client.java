import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("127.0.0.1", 8000);

//        byte[] bytes = new byte[256];
//        clientSocket.getInputStream().read(bytes);
//        System.out.println(new String(bytes));

        BufferedWriter writer =
                new BufferedWriter(
                        new OutputStreamWriter(
                                clientSocket.getOutputStream()));
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));

//        writer.write("GET HTTP/1.1 200 OK\n\n" +
//                "Content-type: text/html\n" +
//                "<h2>Hello JAVA " + count + "</h2>\n");

        writer.write("Get me some information #\n");
        writer.flush();

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        //String message = reader.readLine();
        //System.out.println(message);

        reader.close();
        writer.close();

        clientSocket.close();
    }
//
}

