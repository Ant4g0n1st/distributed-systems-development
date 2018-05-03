package dsd.timers.graphics;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ControlPanel extends JPanel{

    private InputButton button = null;
    private TimerPanel panel = null;
    private TimerInput input = null;

    public ControlPanel(TimerPanel panel){
        this.panel = panel;
        configure();
    }

    private void configure(){
        try{
            button = new InputButton(this);
            setLayout(new BorderLayout());
            input = new TimerInput();
            add(button, BorderLayout.CENTER);
            add(input, BorderLayout.WEST);
        }catch(Exception e){
            System.out.println("Exception at "
                + "ControlPanel."
                + "configure() : "
                + e.getMessage());
        }
    }

    public void editTimer(){
        panel.editTimer(input.getInput());
        input.clear();
    }

    public void addTimer(){
        panel.addTimer(input.getInput());
        input.clear();
    }

    public void enableEditing(){
        button.enableEditing();
        input.clear();
    }

    public void disableEditing(){
        button.disableEditing();
        input.clear();   
    }

}