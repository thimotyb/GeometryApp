package com.awacademy.geometry;

import com.awacademy.geometry.base.Point;
import com.awacademy.geometry.shapes.Circle;
import com.awacademy.geometry.shapes.Rectangle;
import com.awacademy.geometry.shapes.Square;

import java.util.*;

public class GeometryCanvas {

    public static int command;
    public static int x;
    public static int y;
    public static int length;
    //public static int attempts = 0;
    //public static Object[] array = new Object[attempts];
    public static List<Object> array = new ArrayList<>();
    public static Map<String, List<Object>> myShapeDictionary = new LinkedHashMap<>();

    public static void main(String[] args) {

        myShapeDictionary.put("Circles", new ArrayList<Object>());
        myShapeDictionary.put("Squares", new ArrayList<Object>());
        myShapeDictionary.put("Rectangles", new ArrayList<Object>());

        while (command != 4) {

            boolean thereWasAConversionError = false;
            Scanner sc = new Scanner(System.in);
            System.out.println("Which shape would you like to add?\n1. Square\n2. Circle\n3. Rectangle\n4. Stop and exit");
            String input = sc.nextLine();

            try {
                command = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                thereWasAConversionError = true;
            }

            try {

                if (command == 1 && !thereWasAConversionError) {
                    //array = Arrays.copyOf(array, array.length + 1);
                    System.out.println("x-coordinate of upper left corner?");
                    x = sc.nextInt();
                    System.out.println("y-coordinate of upper left corner?");
                    y = sc.nextInt();
                    System.out.println("Length of side?");
                    length = sc.nextInt();
                    Point corner1 = new Point(x, y);
                    Square square = new Square(corner1, length);
                    //array.add(square);
                    myShapeDictionary.get("Squares").add(square);
                } else if (command == 2 && !thereWasAConversionError) {
                    //array = Arrays.copyOf(array, array.length + 1);
                    System.out.println("x-coordinate of center point?");
                    x = sc.nextInt();
                    System.out.println("y-coordinate of center point?");
                    y = sc.nextInt();
                    System.out.println("Radius?");
                    length = sc.nextInt();
                    Point center = new Point(x, y);
                    Circle circle = new Circle(center, length);
                    //array.add(circle);
                    myShapeDictionary.get("Circles").add(circle);
                } else if (command == 3 && !thereWasAConversionError) {
                    //array = Arrays.copyOf(array, array.length + 1);
                    System.out.println("x-coordinate of upper left corner?");
                    x = sc.nextInt();
                    System.out.println("y-coordinate of upper left corner?");
                    y = sc.nextInt();
                    System.out.println("Length of width?");
                    length = sc.nextInt();
                    System.out.println("Length of height?");
                    int length2 = sc.nextInt();
                    Point corner1 = new Point(x, y);
                    Rectangle rectangle = new Rectangle(corner1, length, length2);
                    //array.add(rectangle);
                    myShapeDictionary.get("Rectangles").add(rectangle);
                } else if (command == 4 && !thereWasAConversionError) {
                    break;
                } else {
                    System.out.println("Error, try again");
                }
            } catch (InputMismatchException e){
                System.out.println("You didn't type a number");
            }

            //attempts++;
        }

        for (String key: myShapeDictionary.keySet()) {
            List<Object> array = myShapeDictionary.get(key);
            if (array.size() == 0) {
                System.out.println(String.format("There is nothing to print for key %s.", key));
            } else {
                System.out.println(array);
            }
        }

        }
        public static void oldExamples() {

        //        int point1_x = 1;
//        int point1_y = 2;

        // Dear other programmer: from now remember that the first element is x and the second element is y
        int[] point1 = { 1, 2 };

        Point p1 = new Point(1, 2);
        //p1.x = 1;
        //p1.y = 2;

            int point2_y = 10;

        int point2_x = 5;
        int[] point2 = { 5, 10 };

        Point p2 = new Point(5, 10);
        //p2.x = 5;
        //p2.y = 10;

        int point3_x = 9;
        int point3_y = 10;

        //double distance = Math.sqrt(Math.pow(point2_x- point1_x, 2) + Math.pow(point2_y - point1_y, 2));
        //double distance = Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
        //double distance = Math.sqrt(Math.pow(p2.getX()- p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        double distance = p1.calculateDistance(p2);

        // Non-static method: it is applied at instance level (the "real" point, e.g. p2)
        p2.moveHorizontally(5);

        // I what to shift horiz of 5 units
        // p2.x += 5;


        // Static method: it is applied at class level (I don't need to know a specific instance to use it)
        Point p3 = Point.moveAnyPointHorizontally(p1, 3);

        System.out.println(p2.toString());
        System.out.println(p1.toString());
        System.out.println(p3.toString());

        System.out.println("The distance is: "+distance);

        // A programmer is a DRY person

        Point p4 = Point.moveAnyPointHorizontally(p1, 0);
        //Point p4 = p1;
        System.out.println(((Object)p1).toString());
        System.out.println(((Object)p4).toString());
        if (p1.equals(p4)) {
            System.out.println("The two points are equal.");
        } else {
            System.out.println("The two points are DIFFERENT.");
        }

    }

}

