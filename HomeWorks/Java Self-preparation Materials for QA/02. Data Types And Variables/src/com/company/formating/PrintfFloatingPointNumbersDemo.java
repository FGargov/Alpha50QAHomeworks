package com.company.formating;

public class PrintfFloatingPointNumbersDemo {
    public static void main(String[] args) {
        double pi = Math.PI;

        // %f - floating-point number
        System.out.format("%f%n", pi);
        // %f - floating-point number - 3 digits after the point
        System.out.format("%.3f%n", pi);
    }
}
