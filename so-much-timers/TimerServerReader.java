package dsd;

import java.io.IOException;

import java.net.Socket;

public class TimerServerReader
    extends TimerReader implements Runnable{

    private TimerClientHandler handler = null;
    private boolean running = true;

    public TimerServerReader(Socket s)
        throws IOException{
        super(s);
    }

    public void setHandler(TimerClientHandler handler){
        this.handler = handler;
    }

    @Override
    public void run(){
        while(running){
            Timer timer = null;
            try{
                timer = readTimer();
                handler.sendTimer(timer);
            }catch(Exception e){
                running = false;
            }
        }
    }

    public void start(){
        new Thread(this).start();
    }

}