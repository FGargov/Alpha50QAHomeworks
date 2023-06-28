package com.gargov;

import com.gargov.enums.Color;

public abstract class Shape {
    private final Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected abstract double getArea();
}
