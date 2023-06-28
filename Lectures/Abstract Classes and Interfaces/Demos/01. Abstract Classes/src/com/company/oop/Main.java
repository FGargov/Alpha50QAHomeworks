package com.company.oop;

import com.company.oop.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = generateListOfShapes();
        for (Shape shape : shapes) {
            System.out.printf(
                    "This %s %s has area: %.2f %n",
                    shape.getColor().toString().toLowerCase(),
                    shape.getClass().getSimpleName(),
                    shape.getArea());
        }
    }

    private static List<Shape> generateListOfShapes() {
        // Shape shape = new Shape(); //error!!! shape is abstract class

        Shape circle = new Circle(Color.BLUE, 4.5);
        Shape triangle = new Triangle(Color.GREEN, 3, 8);
        Shape rectangle = new Rectangle(Color.YELLOW, 6, 7);

        List<Shape> shapes = new ArrayList<>();

        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);

        return shapes;
    }
}
