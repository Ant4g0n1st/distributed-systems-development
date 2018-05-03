package dsd.timers.graphics;

import dsd.timers.graphics.exceptions.InvalidInputException;

import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;

import java.awt.Dimension;
import java.awt.Insets;

public class NumberInput extends JPanel{

    private static final Insets MARGIN = new Insets(5, 5, 5, 5);
    private static final Dimension SPACE = new Dimension(4, 0);
    private static final int INPUT_WIDTH = 2;
    public static final int EMPTY = -1;

    protected JTextField input = null;
    private JLabel label = null;
    private JPanel panel = null;

    public NumberInput(JPanel panel, String text){
        this.label = new JLabel(text + ":");
        this.panel = panel;
        configure();
    }

    public void add(){
        try{
            panel.add(label);
            panel.add(Box.createRigidArea(SPACE));
            panel.add(input);
            setBorder(new EmptyBorder(MARGIN));
        }catch(Exception e){
            System.out.println("Exception at "
                + "NumberInput."
                + "add() : "
                + e.getMessage());
        }
    }

    private void configure(){
        try{
            input = new JTextField(INPUT_WIDTH);
            label.setLabelFor(input);
        }catch(Exception e){
            System.out.println("Exception at "
                + "NumberInput."
                + "configure() : "
                + e.getMessage());
        }
    }

    protected int getInput(String regex) 
        throws InvalidInputException{
        String text = input.getText().trim();
        if(text.isEmpty()) return EMPTY;
        if(text.matches(regex))
            return Integer.parseInt(text);
        throw new InvalidInputException(text);
    }

    public int getInput() 
        throws InvalidInputException{
        return getInput("^[0-5]{0,1}[0-9]$");
    }

    public void clear(){
        input.setText(null);
    }

}