package dsd.timers.server.graphics;

import dsd.timers.server.core.TimerClientManager;

import dsd.timers.graphics.TimerDisplay;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;

import dsd.timers.core.Timer; 

public class ServerTimerDisplay extends TimerDisplay
    implements MouseListener{

    private static final Color EVEN_FONT_COLOR = Color.WHITE;
    private static final Color ODD_FONT_COLOR = Color.BLACK;
    private static final Color EVEN_COLOR = Color.DARK_GRAY;
    private static final Color ODD_COLOR = Color.LIGHT_GRAY;
    private static final int DISPLAY_HEIGHT = 44;
    private static final int DOUBLE_CLICK = 2;
    private static final int TRIPLE_CLICK = 3;

    private static int instanceCounter = 0;

    private TimerClientManager tcm = null;
    private DisplayPanel panel = null;
    private boolean canEdit = true;

    public ServerTimerDisplay(TimerClientManager tcm, DisplayPanel panel, Timer timer){
        super(timer);   
        this.panel = panel;
        this.tcm = tcm;
        this.tcm.sendTimer(timer);
        configure();
        start();
    }

    public ServerTimerDisplay(DisplayPanel panel, Timer timer){
        super(timer);   
        this.panel = panel;
        configure();
        start();
    }

    protected void configure(){
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

    @Override
    public void mouseClicked(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON1){
            if(e.isControlDown()){
                tcm.sendTimer(this.timer);
                return;
            }
            if(e.getClickCount() == DOUBLE_CLICK){
                if(!canEdit) return;
                canEdit = false;
                    panel.setEditable(this);
                canEdit = true;
            }
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

}