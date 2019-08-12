package io.timeserver.aio;

/**
 * User: aaa
 */
public class TimeServerAIO {
    public static void main(String[] args) {
        int port = 8080;

        AsyncTimeServerHandler timeServerHandler = new AsyncTimeServerHandler(port);
        new Thread(timeServerHandler,"AIO-AsyncTimeServerHandler-001").start();
    }

}
