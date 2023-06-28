package com.company.oop.shapeandmovable;

import com.company.oop.shapeandmovable.enums.Direction;
import com.company.oop.shapeandmovable.interfaces.Movable;

public class Point implements Movable {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(double distance, Direction direction) {
        switch (direction) {
            case UP:
                y -= distance;
                break;
            case DOWN:
                y += distance;
                break;
            case LEFT:
                x -= distance;
                break;
            case RIGHT:
                x += distance;
                break;
            default:
                throw new IllegalArgumentException("No such direction");
        }
    }

    @Override
    public String toString() {
        return String.format("{x:%.2f,y:%.2f}", x, y);
    }
}
