package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * The main window for the game of pong
 */
public class GameWindow extends JFrame {
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 600;
    private JLabel scoreDisplay;
    private int score = 0;
    private JButton newGameBtn;
    private JPanel gamePanel;



    public GameWindow(){
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
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

        scoreDisplay = new JLabel("Score = " + score);
        statusBar.add(scoreDisplay);

        newGameBtn = new JButton("New Game");
        newGameBtn.setFocusable(false);
        statusBar.add(newGameBtn);

        this.add(statusBar, BorderLayout.NORTH);
    }


    /**
     * Resets the score display in the status bar
     */
    private void setScore(){
        this.scoreDisplay.setText("Score = " + score);
    }




    /**
     * Manages the ball and paddle
     */
    private class GamePanel extends JPanel {
        Ball ball = new Ball();
        Paddle paddle = new Paddle();

        Timer timer;

        public GamePanel(){
            this.setBackground(Color.BLACK);

            this.addMouseWheelListener(new MouseAdapter() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    movePaddle(e.getPreciseWheelRotation() * 12);
                }
            });



            //FIXME: doesnt work for some reason
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int isUp;

                    if(e.getKeyCode() == KeyEvent.VK_KP_UP){
                        isUp = 1;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_KP_DOWN){
                        isUp = -1;
                    }
                    else {
                        System.out.println("other key");
                        return;
                    }


                    movePaddle(50 * isUp);
                }
            });


            this.requestFocus(false);
        }


        /**
         * Moves the paddle the specified amount
         * @param distance the distance the paddle should be moved, negative means up
         */
        private void movePaddle(double distance){
            double position = paddle.y + distance;

            //ensure we don't move off the screen
            position = Math.min(position, (SCREEN_HEIGHT - Paddle.PADDLE_HEIGHT));
            position = Math.max(0, position);

            paddle.y = (int) position;

            repaint();
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
