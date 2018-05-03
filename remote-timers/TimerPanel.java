package dsd.timers.server.graphics;

import dsd.timers.server.core.TimerClientManager;

import dsd.timers.core.Timer;

import java.net.ServerSocket;
import java.net.Socket;

import java.awt.BorderLayout;

import java.io.IOException;

import javax.swing.JPanel;

public class TimerPanel extends JPanel{

    private DisplayPanelWrapper display = null;
    private ServerTimerDisplay edit = null;
    private ControlPanel controls = null;
    private ServerSocket server = null;

    public TimerPanel(){
        configure();
    }

    private void configure(){
        try{
            setLayout(new BorderLayout());
            display = new DisplayPanelWrapper(this);
            controls = new ControlPanel(this);
            add(controls, BorderLayout.NORTH);
            add(display, BorderLayout.CENTER);
        }catch(Exception e){
            System.out.println("Exception at "
                + "TimerPanel."
                + "configure() : "
                + e.getMessage());
        }
    }
    
    public void setEditable(ServerTimerDisplay newEdit){
        if(newEdit == null) return;
        if(edit != null){
            edit.resume();
            edit = null;
        }
        controls.enableEditing();
        edit = newEdit;
        edit.pause();
    }

    public void editTimer(Timer timer){
        if(timer == null) return;
        if(edit == null) return;
        controls.disableEditing();
        edit.replaceTimer(timer);
        edit.resume();
        edit = null;
    }

    public void addTimer(TimerClientManager tcm){
        if(tcm == null) return;
        display.addTimer(tcm);
    }

    public void addTimer(Timer timer){
        if(timer == null) return;
        display.addTimer(timer);
    }

}