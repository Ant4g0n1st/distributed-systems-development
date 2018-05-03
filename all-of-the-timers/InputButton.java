package dsd.timers.graphics;

import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Insets; 

public class InputButton extends JPanel implements MouseListener{

    private static final Insets MARGIN = new Insets(2, 0, 0, 0);

    private ControlPanel panel = null;
    private boolean editMode = false;
    private boolean canInput = true;
    private JButton button = null;

    public InputButton(ControlPanel panel){
        this.panel = panel;
        configure();
    }

    private void configure(){
        try{
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBorder(new EmptyBorder(MARGIN));
            button = new JButton("Create");
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setAlignmentY(Component.CENTER_ALIGNMENT);
            button.addMouseListener(this);
            add(button);
        }catch(Exception e){
            System.out.println("Exception at "
                + "InputButton."
                + "configure() : "
                + e.getMessage());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseClicked(MouseEvent e){
        if(!canInput) return;
        canInput = false;
        if(editMode)
            panel.editTimer();
        else panel.addTimer();
        canInput = true;
    }

    @Override
    public void mouseExited(MouseEvent e){}

    public void disableEditing(){
        button.setText("Create");
        editMode = false;
    }

    public void enableEditing(){
        button.setText("Edit");
        editMode = true;
    }

}