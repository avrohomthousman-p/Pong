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
    static final int BALL_HEIGHT = 40;
    static final int BALL_WIDTH = 40;
    private final BallSize ballSize = new BallSize(BALL_WIDTH, BALL_HEIGHT);
    private final BallLocation ballLocation = new BallLocation();
    private Ellipse2D ball;
    private final Timer timer;



    public GamePanel() {
        this.timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: make ball bounce if at the edge of the screen
                ballLocation.move();
                ball.setFrame(ballLocation, ballSize);
                repaint();
            }
        });

    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        ball = new Ellipse2D.Double(ballLocation.getX(), ballLocation.getY(),
                ballSize.getWidth(), ballSize.getHeight());

        g2D.fill(ball);

        timer.start();
    }
}
