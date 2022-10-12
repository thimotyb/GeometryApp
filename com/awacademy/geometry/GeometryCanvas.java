package com.awacademy.geometry;

import com.awacademy.geometry.base.Point;

public class GeometryCanvas {

    public static void main(String[] args) {

//        int point1_x = 1;
//        int point1_y = 2;

        // Dear other programmer: from now remember that the first element is x and the second element is y
        int[] point1 = { 1, 2 };

        Point p1 = new Point(1, 2);
        //p1.x = 1;
        //p1.y = 2;

        int point2_x = 5;
        int point2_y = 10;

        int[] point2 = { 5, 10 };

        Point p2 = new Point(5, 10);
        //p2.x = 5;
        //p2.y = 10;

        int point3_x = 9;
        int point3_y = 10;

        //double distance = Math.sqrt(Math.pow(point2_x- point1_x, 2) + Math.pow(point2_y - point1_y, 2));
        //double distance = Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
        double distance = Math.sqrt(Math.pow(p2.getX()- p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));

        // Non-static method: it is applied at instance level (the "real" point, e.g. p2)
        p2.moveHorizontally(5);

        // I what to shift horiz of 5 units
        // p2.x += 5;


        // Static method: it is applied at class level (I don't need to know a specific instance to use it)
        Point p3 = Point.moveAnyPointHorizontally(p1, 3);

        System.out.println(String.format("THe current coordinates of p2 are: (%d, %d)", p2.getX(), p2.getY()));
        System.out.println(String.format("THe current coordinates of p1 are: (%d, %d)", p1.getX(), p1.getY()));
        System.out.println(String.format("THe current coordinates of p3 are: (%d, %d)", p3.getX(), p3.getY()));

        System.out.println("The distance is: "+distance);

    }

}


