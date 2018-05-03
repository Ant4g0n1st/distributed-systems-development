package dsd.timers.graphics;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import dsd.timers.core.Timer;

import java.awt.Insets;

public class DisplayPanel extends JPanel{

    private DisplayPanelWrapper panel = null;

    public DisplayPanel(){
        configure();
    }

    private void configure(){
        try{
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }catch(Exception e){
            System.out.println("Exception at "
                + "DisplayPanel."
                + "configure() : "
                + e.getMessage());
        }
    }

    public void setWrapper(DisplayPanelWrapper panel){
        this.panel = panel;
    }

    public void setEditable(TimerDisplay edit){
        panel.setEditable(edit);
    }

    public void addTimer(Timer timer){
        add(new TimerDisplay(this, timer));
        revalidate();
    }

}