package com.company.oop.directions;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.printf("%f %f %n", x, y);
    }

    public void move(Direction dir, double dist) {
        switch (dir) {
            case UP:
                y += dist;
                break;
            case DOWN:
                y -= dist;
                break;
            case LEFT:
                x -= dist;
                break;
            case RIGHT:
                x += dist;
                break;
        }
    }
}
