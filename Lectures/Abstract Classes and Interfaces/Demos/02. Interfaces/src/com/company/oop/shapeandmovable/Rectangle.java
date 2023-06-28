package com.company.oop.shapeandmovable;

import com.company.oop.shapeandmovable.enums.Color;
import com.company.oop.shapeandmovable.enums.Direction;
import com.company.oop.shapeandmovable.interfaces.Movable;

public class Rectangle extends Shape implements Movable {
    private Point center;
    private final double width;
    private final double height;

    public Rectangle(Color color, Point center, double width, double height) {
        super(color);
        this.center = center;
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Point getCenter() {
        return center;
    }

    @Override
    protected double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("Rectangle with center: %s, width: %.2f, height: %.2f",
                getCenter(), getWidth(), getHeight());
    }

    @Override
    public void move(double distance, Direction direction) {
        center.move(distance, direction);
    }
}
