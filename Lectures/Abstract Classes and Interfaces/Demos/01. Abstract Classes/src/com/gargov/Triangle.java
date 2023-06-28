package com.gargov;

import com.gargov.enums.Color;

public class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(Color color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public double getBase(){
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    protected double getArea() {
        return base * height / 2;
    }
}
