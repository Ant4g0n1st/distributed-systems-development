package dsd.timers.client.core;

import dsd.timers.client.graphics.ClientTimerDisplay;

import dsd.timers.client.core.ClientSocket;

import java.io.ObjectInputStream;

import dsd.timers.core.Timer;

import java.io.IOException;

public class TimerReader implements Runnable{

    private ClientTimerDisplay ctd = null;
    private ObjectInputStream ois = null;
    private ClientSocket cs = null;
    private boolean running = true;

    public TimerReader(ClientTimerDisplay ctd){
        this.ctd = ctd;
        initReader();
    }

    private void initReader(){
        try{
            cs = new ClientSocket();
            ois = new ObjectInputStream(cs.getInputStream());
        }catch(IOException e){
            System.out.println("Exception at "
                + "TimerReader."
                + "initReader() : " 
                + e.getMessage());
        }
    }

    public Timer readTimer() throws Exception{
        return Timer.class.cast(ois.readObject());
    }

    @Override
    public void run(){
        while(running){
            Timer t = null;
            try{
                t = readTimer();
                ctd.replaceTimer(t); 
            }catch(Exception e){
                System.exit(0);
            }
        }
    }

    public void start(){
        new Thread(this).start();
    }

}