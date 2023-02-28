package org.example;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Timer;


/**
 * Object that tracks the location and direction of the ball on the screen.
 */
public class BallLocation extends Point2D {
    private double currentX;
    private double currentY;
    private double xVelocity;
    private double yVelocity;


    public BallLocation() {
        currentX = MainFrame.WINDOW_WIDTH / 2.0;
        currentY = MainFrame.WINDOW_HEIGHT / 2.0;
        xVelocity = -4;
        yVelocity = -4;
    }


    public BallLocation(double startingX, double startingY, double xVelocity, double yVelocity){
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


    /**
     * Inverts the velocity in the Y direction, causing the ball to switch between right and left.
     */
    private void invertXVelocity(){
        xVelocity *= -1;
    }


    /**
     * Inverts the velocity in the Y direction, causing the ball to switch between up and down.
     */
    private void invertYVelocity(){
        yVelocity *= -1;
    }


    /**
     * Gets the current velocity of the ball in the X direction (right and left travel).
     *
     * @return The current velocity of the ball.
     */
    public double getXVelocity() {
        return xVelocity;
    }


    /**
     * Gets the current velocity of the ball in the Y direction (up and down travel).
     *
     * @return The current velocity of the ball.
     */
    public double getYVelocity() {
        return yVelocity;
    }

    @Override
    public double getX() {
        return currentX;
    }


    @Override
    public double getY() {
        return currentY;
    }


    @Override
    public void setLocation(double x, double y) {
        this.currentX = x;
        this.currentY = y;
    }
}
