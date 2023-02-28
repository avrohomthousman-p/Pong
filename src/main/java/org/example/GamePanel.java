package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

/**
 * JPanel that runs the game in it.
 */
public class GamePanel extends JPanel {
    private final Timer timer;
    private final BallTracker ball;



    public GamePanel() {
        this.timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: move ball
                repaint();
            }
        });

        ball = new BallTracker();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        Ellipse2D ballDrawing = new Ellipse2D.Double();
        g2D.fill(ballDrawing);

        timer.start();
    }
}
