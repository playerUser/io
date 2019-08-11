package io.timeserver.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * User: aaa
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

//            for (int i = 0; i < 100; i++) {
//
//                out.println("QUERY TIME ORDER");
//                System.out.print("Send order 2 server succeed: " + i + " ");
//                String resp = in.readLine();
//                System.out.println(resp);
//
//            }
//            out.println("STOP");
            out.println("QUERY TIME ORDER");
            System.out.println("send order 2 server succeed");
            String resp = in.readLine();
            System.out.println(resp);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                out.close();
                out = null;
            }
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }


        }
    }

}
