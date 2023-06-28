package com.telerikacademy.core;

import java.util.Scanner;

public class MethodParametersDemo {
    public static void main(String[] args) {
        String name = readUserName();
        // tha `name` variable is called an argument for the `greetUser` method
        greetUser(name);

        sumTwoNumbers();
    }

    // this is a method that doesn't take parameters and returns a result
    public static String readUserName() {
        System.out.print("Please, enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }

    // this is a method that takes one parameter of type String and doesn't return result
    public static void greetUser(String name) {
        System.out.printf("Hello, %s!%n", name);
    }

    // this is a method that doesn't take parameters and doesn't return result
    public static void sumTwoNumbers() {
        System.out.println("Enter two numbers with space between them: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        // a and b are arguments for the method sum
        int sum = sum(a, b);
        System.out.printf("Sum is: %d%n", sum);
    }

    // this is a method that takes two parameters of type int and returns their sum as a result
    public static int sum(int x, int y) {
        int result = x + y;
        return result;
    }
}
