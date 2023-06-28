package com.company.oop.primitive;

public class Main {
    public static void main(String[] args) {
        int x = 10;
        double pi = 3.14;
        char ch = 'A';

        System.out.printf(" %d %.2f %c %n%n", x, pi, ch);

        // y is declared to be of type int and its value is set to be same as the value of x
        // each variable holds its value independently
        int y = x;
        //when value of the x is changed - value of the y remains the same
        x = 20;
        System.out.printf(" x value: %d %n y value: %d", x, y);
    }
}
