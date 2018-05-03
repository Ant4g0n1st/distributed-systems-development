package dsd;

import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Box;

import java.awt.Dimension;
import java.awt.Insets;

public class TimerInput extends JPanel{

    private static final Insets MARGIN = new Insets(5, 5, 5, 5);
    private static final Dimension SPACE = new Dimension(10, 0);

    private NumberInput minutes = null;
    private NumberInput seconds = null;
    private NumberInput hours = null;

    public TimerInput(){
        configure();
    }

    private void configure(){
        try{
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            minutes = new NumberInput(this, "Minutes");
            seconds = new NumberInput(this, "Seconds");
            hours = new HoursInput(this, "Hours");
            setBorder(new EmptyBorder(MARGIN));
            hours.add();
            add(Box.createRigidArea(SPACE));
            minutes.add();
            add(Box.createRigidArea(SPACE));
            seconds.add();
        }catch(Exception e){
            System.out.println("Exception at "
                + "TimerInput."
                + "configure() : "
                + e.getMessage());
        }
    }

    public Timer getInput(){
        try{
            int m = minutes.getInput();
            int s = seconds.getInput();
            int h = hours.getInput();
            if(h == NumberInput.EMPTY
                && m == NumberInput.EMPTY 
                && s == NumberInput.EMPTY)
                return new Timer();
            if(h != NumberInput.EMPTY
                && m != NumberInput.EMPTY 
                && s != NumberInput.EMPTY)
                return new Timer(h, m, s);  
            throw new InvalidInputException();
        }catch(InvalidInputException e){
            System.out.println("Exception at "
                + "TimerInput."
                + "getInput() : "
                + e.getMessage());
        }
        return null;
    }

    public void clear(){
        minutes.clear();
        seconds.clear();
        hours.clear();
    }

}