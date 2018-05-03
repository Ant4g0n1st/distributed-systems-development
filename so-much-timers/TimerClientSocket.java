package dsd;

import java.io.IOException;

import java.net.Socket;

public class TimerClientSocket extends Socket{

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 10124;

    public TimerClientSocket()
        throws IOException{
        super(HOST, PORT);
    }

}