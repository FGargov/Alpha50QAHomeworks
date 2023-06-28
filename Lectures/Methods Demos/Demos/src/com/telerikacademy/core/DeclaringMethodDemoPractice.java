package com.telerikacademy.core;

public class DeclaringMethodDemoPractice {
    public static void main(String[] args) {
        printMessage();

        String greeting = getGreetingMessage();
        System.out.println(greeting);
    }

    private static void printMessage() {
        System.out.println("Hello, Telerik Academy!");
        System.out.println("This is a demo message.");
    }

    private static String getGreetingMessage() {
        return "Good luck in the Alpha program!";
    }
}
