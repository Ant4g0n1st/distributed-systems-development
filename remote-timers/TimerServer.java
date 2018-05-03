package dsd.timers.server.core;

import dsd.timers.server.graphics.TimerPanel;

import java.io.IOException;

import java.net.Socket;

public class TimerServer implements Runnable{

    private TimerServerSocket tss = null;
    private boolean running = true;
    private TimerPanel tp = null;

    public TimerServer(TimerPanel tp){
        initServer();
        this.tp = tp;
        new Thread(this).start();
    }

    @Override
    public void run(){
        while(running){
            TimerClientManager tcm = null;
            try{
                Socket s = tss.accept();
                tcm = new TimerClientManager(s);
                tp.addTimer(tcm);
            }catch(IOException e){
                System.out.println("Exception at"
                    + "TimerServer."
                    + "run() : " 
                    + e.getMessage());
            }
        }
    }

    private void initServer(){
        try{
            tss = new TimerServerSocket();
        }catch(IOException e){
            System.out.println("Exception at"
                + "TimerServer."
                + "initServer() : " 
                + e.getMessage());
        }
    }

}