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
                if(isOffScreenLeftSide() || isOffScreenRightSide()){
                    ballLocation.invertXVelocity();
                }
                else if (isOffScreenTop() || isOffScreenBottom()) {
                    ballLocation.invertYVelocity();
                }
                ballLocation.move();
                ball.setFrame(ballLocation, ballSize);
                repaint();
            }
        });

    }


    /**
     * Checks if the ball has gone off the right side of the screen;
     *
     * @return true if the ball has gone off the right side of the screen, or false otherwise;
     */
    private boolean isOffScreenRightSide(){
        return ballLocation.getX() >= this.getWidth() - ballSize.getWidth();
    }


    /**
     * Checks if the ball has gone off the left side of the screen;
     *
     * @return true if the ball has gone off the left side of the screen, or false otherwise;
     */
    private boolean isOffScreenLeftSide(){
        return ballLocation.getX() <= 0;
    }


    /**
     * Checks if the ball has gone off the top of the screen;
     *
     * @return true if the ball has gone off the top of the screen, or false otherwise;
     */
    private boolean isOffScreenTop(){
        return ballLocation.getY() <= 0;
    }


    /**
     * Checks if the ball has gone off the bottom of the screen;
     *
     * @return true if the ball has gone off the bottom of the screen, or false otherwise;
     */
    private boolean isOffScreenBottom(){
        return ballLocation.getY() >= this.getHeight() - ballSize.getHeight();
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
