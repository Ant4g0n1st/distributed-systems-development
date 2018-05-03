package dsd.timers.server.core;

import java.io.ObjectOutputStream;
import java.io.IOException;

import dsd.timers.core.Timer;

import java.net.Socket;

public class TimerClientManager{

    private ObjectOutputStream oos = null;
    private Socket s = null;

    public TimerClientManager(Socket s){
        this.s = s;
        initManager();
    }

    private void initManager(){
        try{
            oos = new ObjectOutputStream(s.getOutputStream());
        }catch(IOException e){
            System.out.println("Exception at"
                + "TimerClientManager."
                + "initManager() : " 
                + e.getMessage());
        }
    }

    public void sendTimer(Timer timer){
        try{
            if(s.isClosed()) return;
            oos.writeObject(timer);
            oos.flush();
        }catch(IOException e){
            System.out.println("Exception at"
                + "TimerClientManager."
                + "initManager() : " 
                + e.getMessage());
        }
    }

}