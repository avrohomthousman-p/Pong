package org.example;

import java.awt.*;
import java.util.Timer;


/**
 * Tracks the location and direction of the ball on the screen.
 */
public class BallTracker {
    public final int HEIGHT = 40;
    public final int WIDTH = 40;
    public double currentX;
    public double currentY;
    public double xVelocity;
    public double yVelocity;


    public BallTracker(){}


    public BallTracker(double startingX, double startingY, double xVelocity, double yVelocity){
        this.currentX = startingX;
        this.currentY = startingY;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }


    /**
     * Updates the X and Y coordinate of the ball to simulate a move.
     */
    public void move(){
        currentX += xVelocity;
        currentY += yVelocity;
    }
}
