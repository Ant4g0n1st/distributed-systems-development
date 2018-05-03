package dsd;

import java.io.ObjectInputStream;
import java.io.IOException;

import java.net.Socket;

public class TimerReader
    extends ObjectInputStream{

    public TimerReader(Socket s)
        throws IOException{
        super(s.getInputStream());
    }

    protected Timer readTimer()
        throws ClassNotFoundException, IOException{
        return Timer.class.cast(readObject());
    }

}