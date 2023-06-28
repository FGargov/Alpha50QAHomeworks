package com.company.oop.directions;

public class Main {
    public static void main(String[] args) {
        //create Enum from String via valueOf() method
        String directionStr = "up";
        Direction direction = Direction.valueOf(directionStr.toUpperCase());
        Point point = new Point(1.2, 3.4);
        point.move(direction, 6.7);
        point.print();
    }
}
