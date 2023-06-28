package com.company.operators;

public class AssigningValues {
    public static void main(String[] args) {
        int firstValue = 5;
        int secondValue;
        int thirdValue;

        // Using an already declared variable:
        secondValue = firstValue;
        // The following cascade calling assigns
        // 3 to firstValue and then firstValue
        // to thirdValue, so both variables have
        // the value 3 as a result:
        thirdValue = firstValue = 3;

        // This is how we use a literal expression:
        float heightInMeters = 1.74f;

        // Here we use an already initialized variable:
        String greeting = "Hello World!";
        String message = greeting;

        // Print on the console declared variables
        // Use %d for decimal numbers
        // Use %.3f for floating-point numbers, printing 3 digits after the point
        // Use %n for new line
        System.out.printf(
                "%d%n%d%n%d%n%.3f%n%s%n%s%n",
                firstValue,
                secondValue,
                thirdValue,
                heightInMeters,
                greeting,
                message);
    }

}
