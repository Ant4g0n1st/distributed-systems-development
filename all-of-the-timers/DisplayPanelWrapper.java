package dsd.timers.graphics;

import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import dsd.timers.core.Timer;

import java.awt.Insets;

public class DisplayPanelWrapper extends JScrollPane{

    private static final Insets MARGIN = new Insets(0, 0, 0, 0);

    private DisplayPanel display = null;
    private TimerPanel panel = null;

    public DisplayPanelWrapper(TimerPanel panel){
        this(panel, new DisplayPanel());
    }

    private DisplayPanelWrapper(TimerPanel panel, DisplayPanel display){
        super(display,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.display = display;
        this.panel = panel;
        configure();
    }

    private void configure(){
        try{
            setBorder(new EmptyBorder(MARGIN));
            display.setWrapper(this);
        }catch(Exception e){
            System.out.println("Exception at "
                + "DisplayPanelWrapper."
                + "configure() : "
                + e.getMessage());
        }
    }

    public void setEditable(TimerDisplay edit){
        panel.setEditable(edit);
    }

    public void addTimer(Timer timer){
        display.addTimer(timer);
    }

}