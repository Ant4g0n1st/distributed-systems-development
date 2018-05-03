package dsd.timers.server.graphics;

import dsd.timers.server.core.TimerServer;

import dsd.timers.graphics.Window;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Point;

import javax.swing.JFrame;

public class ServerWindow extends Window{

    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 500;

    public ServerWindow(){
        super(WINDOW_WIDTH, WINDOW_HEIGHT);
        configure();
    }

    private void configure(){
        TimerServer ts = null;
        TimerPanel tp = null;
        try{
            tp = new TimerPanel();
            ts = new TimerServer(tp);
            setContentPane(tp);
            setVisible(true);
        }catch(Exception e){
            System.out.println("Exception at "
                + "ServerWindow."
                + "configure() : " 
                + e.getMessage());  
        }
    }

}