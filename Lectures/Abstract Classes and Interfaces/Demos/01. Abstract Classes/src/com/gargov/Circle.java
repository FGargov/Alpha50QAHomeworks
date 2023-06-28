package com.gargov;

import com.gargov.enums.Color;

public class Circle extends Shape {
    private final double radius;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double Radius() {
        return radius;
    }

    @Override
    protected  double getArea() {
        return Math.PI * radius * radius;
    }
}
