package dsd;

import java.io.IOException;

import java.net.Socket;

public class TimerClientReader
    extends TimerReader implements Runnable{

    private static final int READ_DELAY = 1500;

    private TimerClient client = null;
    private boolean running = true;

    public TimerClientReader(Socket s)
        throws IOException{
        super(s);
    }

    public void setClient(TimerClient client){
        this.client = client;
    }

    @Override
    public void run(){
        // Wait for the graphics to load
        try{ 
            Thread.sleep(READ_DELAY);
        }catch(InterruptedException e){}
        while(running){
            Timer timer = null;
            try{
                timer = readTimer();
                client.addTimer(timer);
            }catch(Exception e){
                running = false;
                System.exit(0);
            }
        }
    }

    public void start(){
        new Thread(this).start();
    }

}