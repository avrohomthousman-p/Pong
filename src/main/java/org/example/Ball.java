package org.example;


/**
 * Tracks all data related to the ball and its location, speed, and direction
 */
public class Ball {
    public static final int BALL_HEIGHT = 40;
    public static final int BALL_WIDTH = 40;

    int x = 200;
    int y = 200;

    int deltaX = 5;
    int deltaY = -5;
}