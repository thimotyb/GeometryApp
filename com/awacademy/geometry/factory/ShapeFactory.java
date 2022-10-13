package com.awacademy.geometry.factory;

import com.awacademy.geometry.base.Shape;

import java.util.Scanner;

public class ShapeFactory {

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
