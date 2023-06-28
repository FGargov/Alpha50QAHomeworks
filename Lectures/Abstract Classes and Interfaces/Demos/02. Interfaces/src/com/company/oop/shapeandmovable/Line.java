package com.company.oop.shapeandmovable;

import com.company.oop.shapeandmovable.enums.Color;
import com.company.oop.shapeandmovable.enums.Direction;
import com.company.oop.shapeandmovable.interfaces.Movable;

public class Line implements Movable {
    private Point firstEnd;
    private Point secondEnd;
    private Color color;

    public Line(Point firstEnd, Point secondEnd, Color color) {
        this.firstEnd = firstEnd;
        this.secondEnd = secondEnd;
        this.color = color;
    }

    @Override
    public void move(double distance, Direction direction) {
        firstEnd.move(distance, direction);
        secondEnd.move(distance, direction);
    }

    @Override
    public String toString() {
        return String.format("Line between %s and %s",
                firstEnd, secondEnd);
    }
}
