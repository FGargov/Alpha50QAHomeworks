package com.company.oop.reference;

class Main {
    public static void main(String[] args) {
        //variable point contains the address of the object
        Point point = new Point(3, 4);
        System.out.println(point.print());

        //point2 values is set to be the same as the value of point
        //i.e. point2 contains the same address which points to the same object
        Point point2 = point;
        //changing the object state
        point.setX(20);

        // both point and point2 contain the same address to the same object
        //when the object state is changed all variables pointing this object will show the new state:
        System.out.printf("Point : %s %n", point.print());
        System.out.printf("Point2 : %s %n", point2.print());
    }
}

