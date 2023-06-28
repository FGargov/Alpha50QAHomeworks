package com.telerikacademy.core;

import java.util.Scanner;

public class MethodParametersDemoPractice {
    public static void main(String[] args) {
        String name = readUserName();

        greetUser(name);

        sumTwoNumbers();
    }

    private static String readUserName() {
        System.out.print("Please, enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }

    private static void greetUser(String name) {
        System.out.printf("Hello, %s!%n", name);
    }

    private static void sumTwoNumbers() {
        System.out.println("Enter two numbers with space between them: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = sum(a, b);
        System.out.printf("Sum is: %d%n", sum);
    }

    private static int sum (int a, int b) {
        int result = a + b;
        return result;
    }
}
