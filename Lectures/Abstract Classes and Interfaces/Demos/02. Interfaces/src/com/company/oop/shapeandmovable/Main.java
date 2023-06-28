package com.company.oop.shapeandmovable;

import com.company.oop.shapeandmovable.enums.Color;
import com.company.oop.shapeandmovable.enums.Direction;
import com.company.oop.shapeandmovable.interfaces.Movable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> list = generateListOfShapes();
        List<Movable> movables = generateMovablesList();
        for (Shape shape : list) {
            System.out.printf(
                    "This %s %s has area: %.2f %n",
                    shape.getColor().toString().toLowerCase(),
                    shape.getClass().getSimpleName(),
                    shape.getArea());
        }

        for (Movable movable : movables) {
            System.out.println("Before:");
            System.out.println(movable);
            movable.move(1.5, Direction.UP);
            System.out.println("After:");
            System.out.println(movable);
        }
    }

    private static List<Movable> generateMovablesList() {
        Point center = new Point(4.5, 5.6);
        Point a = new Point(4, 6);
        Point b = new Point(6, 7);

        Circle circle = new Circle(Color.BLUE, 4.5, center);
        Rectangle rectangle = new Rectangle(Color.YELLOW, center, 6, 7);
        Movable line = new Line(a, b, Color.GREEN);

        List<Movable> movableList = new ArrayList<>();

        movableList.add(circle);
        movableList.add(rectangle);
        movableList.add(line);

        return movableList;
    }

    private static List<Shape> generateListOfShapes() {
        // Shape shape = new Shape(); //error!!! shape is abstract class

        Point center = new Point(4.5, 5.6);
        Point a = new Point(4, 6);
        Point b = new Point(6, 7);

        Circle circle = new Circle(Color.BLUE, 4.5, center);
        Rectangle rectangle = new Rectangle(Color.YELLOW, center, 6, 7);
        Movable line = new Line(a, b, Color.GREEN);

        List<Shape> shapeList = new ArrayList<>();

        shapeList.add(circle);
        shapeList.add(rectangle);

        return shapeList;
    }
}
