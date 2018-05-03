package dsd;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.util.TreeMap;

import java.awt.Insets;

public class DisplayPanel extends JPanel{

    private DisplayPanelWrapper panel = null;
    private TimerDisplayStorage tds = null;

    public DisplayPanel(){
        configure();
    }

    private void configure(){
        try{
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            tds = new TimerDisplayStorage();
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

    public void removeDisplay(TimerDisplay td){
        remove(td);
        revalidate();
    }

    public void addTimer(Timer timer){
        TimerDisplay td = null;
        if(tds.updateDisplay(timer))
            return;
        td = new TimerDisplay(this, timer);
        tds.addDisplay(td, timer);
        add(td);
        revalidate();
    }

    public void sendTimer(Timer timer){
        panel.sendTimer(timer);
    }

}