package dsd.timers.graphics;

import dsd.timers.core.Timer;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TimerPanel extends JPanel{

    private DisplayPanelWrapper display = null;
    private ControlPanel controls = null;
    private TimerDisplay edit = null;

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
    
    public void setEditable(TimerDisplay newEdit){
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

    public void addTimer(Timer timer){
        if(timer == null) return;
        display.addTimer(timer);
    }

}