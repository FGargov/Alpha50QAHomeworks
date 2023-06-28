package com.telerikacademy.core;

public class DeclaringMethodDemo {
    public static void main(String[] args) {
        // here we call a method that doesn't return a result
        printMessage();

        // here we call a method that returns a result that se save in a variable
        String greeting = getGreetingMessage();
        System.out.println(greeting);
    }

    // this is a declaration of a method that executes some code and doesn't return a result
    public static void printMessage() {
        System.out.println("Hello, Telerik Academy!");
        System.out.println("This is a demo message.");
    }

    // this is a declaration of a method that returns a String as a result
    public static String getGreetingMessage() {
        return "Good luck in the Alpha program!";
    }
}
