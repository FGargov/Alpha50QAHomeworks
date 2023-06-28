package com.telerikacademy.core;

import java.util.Scanner;

public class MethodReturnTypesDemo {

    // methods order doesn't matter for the compilation and execution of the program
    // but best practices recommend that if `method1` calls `method2`,
    // then `method2` should be lower in the code

    public static void main(String[] args) {
        String name = getValidName();

        printWelcomeMessage(name);
    }

    static String getValidName() {
        System.out.print("Please, enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        // `isNameValid` returns `boolean` so it can be used wherever a `boolean` is expected - like in while
        while (!isNameValid(name)) {
            System.out.println("Please use only letters for your name: ");
            name = scanner.nextLine();
        }

        return name;
    }

    static boolean isNameValid(String name) {
        if (name == null || name.isEmpty()) {
            // code after 'return' is not executed
            return false;
        }

        for (char ch : name.toCharArray()) {
            if (!Character.isAlphabetic(ch)) {
                // another 'early exit' - if we reach a character that is not a letter,
                // there is no point to check the others
                return false;
            }
        }

        // if the flow reaches here, name is valid
        return true;
    }

    static void printWelcomeMessage(String name) {
        System.out.printf("Hello, %s!%n", name);
        System.out.println("Good luck in the Alpha program!");
    }
}
