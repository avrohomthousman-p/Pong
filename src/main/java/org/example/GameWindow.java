package org.example;

import javax.swing.*;
import java.awt.*;


/**
 * The main window for the game of pong
 */
public class GameWindow extends JFrame {
    private JLabel score;
    private JButton newGameBtn;
    private JPanel gamePanel;



    public GameWindow(){
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Pong");

        setupStatusBar();

        gamePanel = new GamePanel();
        this.add(gamePanel);

        this.setVisible(true);
    }


    /**
     * Sets up the status bar
     */
    private void setupStatusBar(){
        JPanel statusBar = new JPanel();

        score = new JLabel("Score = 0");
        statusBar.add(score);

        newGameBtn = new JButton("New Game");
        statusBar.add(newGameBtn);

        this.add(statusBar, BorderLayout.NORTH);
    }


    /**
     * Manages the ball and paddle
     */
    private class GamePanel extends JPanel {
        Ball ball = new Ball();
        Paddle paddle = new Paddle();

        public GamePanel(){
            this.setBackground(Color.BLACK);
        }


        @Override
        public void paint(Graphics g) {
            super.paint(g);

            g.setColor(Color.WHITE);
            g.fillOval(ball.x, ball.y, Ball.BALL_WIDTH, Ball.BALL_HEIGHT);
            g.fillRect(paddle.x, paddle.y, Paddle.PADDLE_WIDTH, Paddle.PADDLE_HEIGHT);
        }
    }
}
