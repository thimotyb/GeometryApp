package com.awacademy.geometry.shapes;

import com.awacademy.geometry.base.Point;

public class Square {

    // Fields
    Point topLeftCorner;
    int sideLength;

    // Pattern: Instance State Injection via Constructor
    public Square(Point topLeftCorner, int sideLength) {
        this.topLeftCorner = topLeftCorner;
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Square{" +
                "topLeftCorner=" + topLeftCorner +
                ", sideLength=" + sideLength +
                '}';
    }
}
