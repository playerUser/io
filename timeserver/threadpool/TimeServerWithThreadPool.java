package io.timeserver.threadpool;

import io.timeserver.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: aaa
 */
public class TimeServerWithThreadPool {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port: " + port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(2, 3);
            while (true) {
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }

        } finally {
            if (null != server) {
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }

    }
}
