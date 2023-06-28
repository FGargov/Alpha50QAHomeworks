package com.company.oop.shapeandmovable;

import com.company.oop.shapeandmovable.enums.Color;

public abstract class Shape {
    private final Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    //all shapes must have area but Shape is too generic and we can't have any meaningful implementation here
    protected abstract double getArea();
}
