package com.company.oop.shapeandmovable;

import com.company.oop.shapeandmovable.enums.Color;
import com.company.oop.shapeandmovable.enums.Direction;
import com.company.oop.shapeandmovable.interfaces.Movable;

public class Circle extends Shape implements Movable {

    private final double radius;
    private Point center;

    public Circle(Color color, double radius, Point center) {
        super(color);
        this.radius = radius;
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    @Override
    protected double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void move(double distance, Direction direction) {
        center.move(distance, direction);
    }

    @Override
    public String toString() {
        return String.format("Circle with center: %s and radius: %.2f",
                getCenter(), getRadius());
    }
}
