package com.awacademy.geometry.base;

import java.util.Scanner;

public interface Shape {

    public double calculateArea();
    public double calculatePerimeter();

    public static Shape askDataAndCreateShape(Scanner sc) { return null; };

}
