package com.awacademy.geometry;

import com.awacademy.geometry.base.Point;
import com.awacademy.geometry.base.Shape;
import com.awacademy.geometry.factory.ShapeFactory;

import java.util.*;

public class GeometryCanvas {

    public static int command;
    public static int x;
    public static int y;
    public static int length;
    //public static int attempts = 0;
    //public static Object[] array = new Object[attempts];
    public static List<Object> array = new ArrayList<>();
    public static Map<String, List<Shape>> myShapeDictionary = new LinkedHashMap<>();

    public static ShapeFactory factory = new ShapeFactory();

    //public static String[] shapeNames = { "Circles", "Squares", "Rectangles" };

    public static LinkedHashMap<Integer, String> supportedShapes = new LinkedHashMap<>();

    /**
     * OCP: Open Closed Principle
     * Open to Extension, Closed to Modification
     * @param args
     */
    public static void main(String[] args) {

        supportedShapes.put(Integer.valueOf(1), "Square");
        supportedShapes.put(Integer.valueOf(2), "Circle");
        supportedShapes.put(Integer.valueOf(3), "Rectangle");

        // TODO: Remember to align the keys of the objects with their types
        //myShapeDictionary.put(shapeNames[0], new ArrayList<Shape>());
        //myShapeDictionary.put(shapeNames[1], new ArrayList<Shape>());
        //myShapeDictionary.put(shapeNames[2], new ArrayList<Shape>());

        for (int i: supportedShapes.keySet()) {
            myShapeDictionary.put(supportedShapes.get(i), new ArrayList<Shape>());
        }

        final int NUMBER_OF_MENU_ITEMS = supportedShapes.size()+1;

        while (command != NUMBER_OF_MENU_ITEMS) {

            boolean thereWasAConversionError = false;
            Scanner sc = new Scanner(System.in);

            StringBuilder menu = new StringBuilder("Which shape would you like to add?\n");

            for (int i: supportedShapes.keySet()) {
                menu.append(i+". "+supportedShapes.get(i)+"\n");
            }

            /*
            menu.append("1. "+supportedShapes.get(1)+"\n");
            menu.append("2. "+supportedShapes.get(2)+"\n");
            menu.append("3. "+supportedShapes.get(3)+"\n");
            */

            menu.append((NUMBER_OF_MENU_ITEMS)+". Stop and Exit");

            System.out.println(menu);

            String input = sc.nextLine();

            try {
                command = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                thereWasAConversionError = true;
            }

            try {

                // If you want to exit
                if (command == NUMBER_OF_MENU_ITEMS && !thereWasAConversionError) break;

                // If you chose a wrong option
                if (command < 1 || command > NUMBER_OF_MENU_ITEMS) {
                    System.out.println("Please, choose an option from the menu.");
                } else if (!thereWasAConversionError) {
                    Shape shape = factory.createShape(command, sc);   // Factory Pattern
                    myShapeDictionary.get(supportedShapes.get(command)).add(shape);
                }

            } catch (InputMismatchException e){
                System.out.println("You didn't type a number");
            }

            //attempts++;
        }

            double totalArea = 0;
            for (String key: myShapeDictionary.keySet()) {
                List<Shape> array = myShapeDictionary.get(key);
                if (array.size() == 0) {
                    System.out.println(String.format("There is nothing to print for key %s.", key));
                } else {
                    System.out.println(array);
                    for(Shape shape: array) {
                            totalArea = totalArea + shape.calculateArea(); // Dynamic binding!!!
                       }
                    }
            }

            System.out.println(String.format("The total area of all your shapes is %f", totalArea));

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

