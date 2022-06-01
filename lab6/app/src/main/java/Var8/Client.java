
package Var8;

import java.io.*;
import java.net.*;


public class Client {

    String result;

    public String getRes() {
        return this.result;
    }

    public void cln(String l, String h, String s) {

        try (Socket socket = new Socket("127.0.0.1", 80);  
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));  
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connecting");

            String request = l + " " + h + " " + s;
            System.out.println("Request:" + request);
            writer.write(request);
            writer.newLine();
            writer.flush();

            result = reader.readLine();
            System.out.println("Result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
