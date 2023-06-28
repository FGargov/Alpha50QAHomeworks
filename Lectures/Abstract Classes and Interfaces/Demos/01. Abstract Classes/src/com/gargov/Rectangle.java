package com.gargov;

import com.gargov.enums.Color;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(Color color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    protected double getArea() {
        return width * height;
    }
}
