package com.awacademy.geometry.factory;

import com.awacademy.geometry.base.Shape;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class ShapeFactory {

    public static LinkedHashMap<Integer, String> supportedShapes = new LinkedHashMap<>();

    public ShapeFactory() {
        supportedShapes.put(Integer.valueOf(1), "Square");
        supportedShapes.put(Integer.valueOf(2), "Circle");
        supportedShapes.put(Integer.valueOf(3), "Rectangle");
    }

    public Shape createShape(int shape, Scanner sc) {
        switch(shape) {
            case 1: // Square
                return new SquareCreator().askDataAndCreateShape(sc);
            case 2: // Circle
                return new CircleCreator().askDataAndCreateShape(sc);
            case 3: // Rectangle
                return new RectangleCreator().askDataAndCreateShape(sc);
            default:
                return null;
        }
    }
}
