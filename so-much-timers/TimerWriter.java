package dsd;

import java.io.ObjectOutputStream;
import java.io.IOException;

import java.net.Socket;

public class TimerWriter
    extends ObjectOutputStream{

    public TimerWriter(Socket s)
        throws IOException{
        super(s.getOutputStream());
    }

    public synchronized void writeTimer(Timer timer)
        throws IOException{
        writeObject(timer);
        flush();
    }

}