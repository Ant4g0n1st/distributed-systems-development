package dsd.timers.server.graphics; 

import dsd.timers.server.graphics.exceptions.InvalidInputException;

import javax.swing.JPanel;

public class HoursInput extends NumberInput{

    public HoursInput(JPanel parent, String text){
        super(parent, text);
    }

    @Override
    public int getInput() 
        throws InvalidInputException{
        return getInput("(^[0-1]{0,1}[0-9]$)|(^[2][0-3]$)");
    }

}