package org.example;

import java.awt.geom.Dimension2D;


/**
 * Object that tracks the size of a ball on the screen.
 */
public class BallSize extends Dimension2D {
    private double width;
    private double height;

    public BallSize(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public void setSize(double width, double height) {
        this.width = width;
        this.height = height;
    }
}
