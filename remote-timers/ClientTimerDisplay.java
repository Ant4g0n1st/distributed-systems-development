package dsd.timers.client.graphics;

import dsd.timers.client.core.TimerReader;

import dsd.timers.graphics.TimerDisplay;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.io.ObjectInputStream;

import dsd.timers.core.Timer;

import java.io.IOException;

import java.awt.Component;
import java.awt.Dimension;

public class ClientTimerDisplay extends TimerDisplay{

    private TimerReader tr = null; 

    public ClientTimerDisplay(){
        super();
        try{
            tr = new TimerReader(this);
            replaceTimer(tr.readTimer());   
            configure();
            start();
            tr.start();
        }catch(Exception e){
            System.exit(0);
        }
    }
    
    protected void configure(){
        try{
            setBorder(new EmptyBorder(MARGIN));
            label = new JLabel(timer.toString());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setAlignmentY(Component.CENTER_ALIGNMENT);
            label.setFont(DISPLAY_FONT);
            add(label);
        }catch(Exception e){
            System.out.println("Exception at "
                + "ClientTimerDisplay."
                + "configure() : "
                + e.getMessage());
        }
    }

}