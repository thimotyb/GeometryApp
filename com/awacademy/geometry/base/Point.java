package com.awacademy.geometry.base;

public class Point {

    // Fields
    // Determining which general variable are used to describe the state of an instance
    private int x; // the x coordinate
    private int y; // the y coordinate

    // Constructor
    public Point(int first_coordinate, int second_coordinate) {
        x = first_coordinate;
        y = second_coordinate;
    }

    // Methods

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Move a point horizontally of a specified offset: non-static, usable only at instance level
    public void moveHorizontally(int offset) {
        this.x += offset;
    }

    public double calculateDistance(Point anotherPoint) {
        return Math.sqrt(Math.pow(anotherPoint.getX()- this.getX(), 2) + Math.pow(anotherPoint.getY() - this.getY(), 2));
    }

    // This is static, generic, usable on the class directly
    // Usage as Immutable class
    public static Point moveAnyPointHorizontally(Point p, int offset) {
        Point newPoint = new Point(p.x, p.y);
        newPoint.x += offset;
        return newPoint;
    }

}
