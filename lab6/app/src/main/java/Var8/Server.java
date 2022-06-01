package Var8;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    public static void main(String[] args) {
        try ( ServerSocket server = new ServerSocket(80)) {
            System.out.println("Server is running");

            while (true) {
                try ( Socket socket = server.accept();  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));  BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    String result;
                    String[] values;

                    String request = reader.readLine();
                    values = request.split(" ");

                    System.out.println("Request:" + values[0] + values[1] + values[2]);

                    String l = values[0];
                    String h = values[1];
                    String s = values[2];
                    ThreadRunable threadRunable = new ThreadRunable(l, h, s);

                    threadRunable.run();
                    result = threadRunable.getResult();

                    System.out.println("Result:" + result);
                    String buf = result;
                    writer.write(buf);
                    writer.newLine();
                    writer.flush();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
