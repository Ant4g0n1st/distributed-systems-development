package dsd.timers.server.core;

import java.net.ServerSocket;

import java.io.IOException;

public class TimerServerSocket extends ServerSocket{

    private static final int PORT = 10124;

    public TimerServerSocket() 
        throws IOException{
        super(PORT);
    }

}