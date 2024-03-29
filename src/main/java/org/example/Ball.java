package org.example;


/**
 * Tracks all data related to the ball and its location, speed, and direction
 */
public class Ball {
    public static final int BALL_HEIGHT = 30;
    public static final int BALL_WIDTH = 30;

    int x = GameWindow.SCREEN_WIDTH / 2;
    int y = GameWindow.SCREEN_HEIGHT / 2;

    int deltaX = 5;
    int deltaY = -5;
}
