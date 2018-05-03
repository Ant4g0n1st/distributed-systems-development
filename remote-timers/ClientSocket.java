package dsd.timers.client.core;

import java.io.IOException;

import java.net.Socket;

public class ClientSocket extends Socket{

    private static final String HOST = "localhost";
    private static final int PORT = 10124;

    public ClientSocket()
        throws IOException{
        super(HOST, PORT);
    }

}