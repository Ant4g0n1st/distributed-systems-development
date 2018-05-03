package dsd.timers.graphics;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;

import dsd.timers.core.Timer; 

public class TimerDisplay extends JPanel 
    implements Runnable, MouseListener{

    private static final Font DISPLAY_FONT = new Font("Arial", Font.PLAIN, 20);
    private static final Insets MARGIN = new Insets(5, 5, 5, 5);
    private static final Color EVEN_FONT_COLOR = Color.WHITE;
    private static final Color ODD_FONT_COLOR = Color.BLACK;
    private static final Color EVEN_COLOR = Color.DARK_GRAY;
    private static final Color ODD_COLOR = Color.LIGHT_GRAY;
    private static final int DISPLAY_HEIGHT = 44;
    private static final int DOUBLE_CLICK = 2;

    private static int instanceCounter = 0;

    private volatile Timer timer = null;
    private DisplayPanel panel = null;
    private boolean canEdit = true;
    private boolean running = true;
    private boolean hold = false;
    private JLabel label = null;

    public TimerDisplay(DisplayPanel panel, Timer timer){
        this.panel = panel;
        this.timer = timer;
        configure();
        new Thread(this).start();
    }

    private void configure(){
        Dimension ps = null;
        try{
            ps = panel.getSize();
            ps.setSize(panel.getWidth(), DISPLAY_HEIGHT);
            label = new JLabel(timer.toString());
            setBorder(new EmptyBorder(MARGIN));
            setMaximumSize(ps);
            if((instanceCounter & 1) == 0){
                label.setForeground(EVEN_FONT_COLOR);
                setBackground(EVEN_COLOR);
            }else{ 
                label.setForeground(ODD_FONT_COLOR);
                setBackground(ODD_COLOR);
            }
            instanceCounter++;
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setAlignmentY(Component.CENTER_ALIGNMENT);
            label.setFont(DISPLAY_FONT);
            add(label);
            panel.add(this);
            addMouseListener(this);
        }catch(Exception e){
            System.out.println("Exception at "
                + "TimerDisplay."
                + "configure() : "
                + e.getMessage());
        }
    }

    public synchronized void replaceTimer(Timer timer){
        this.timer = timer;
    }

    @Override
    public void run(){
        while(running){
            if(!hold){
                timer.increase();
                label.setText(timer.toString());
                revalidate();
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){
        if(e.getClickCount() == DOUBLE_CLICK){
            if(!canEdit) return;
            canEdit = false;
            panel.setEditable(this);
            canEdit = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e){}

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    public void stop(){
        this.running = false;
    }

    public void resume(){
        this.hold = false;
    }

    public void pause(){
        this.hold = true;
    }

}