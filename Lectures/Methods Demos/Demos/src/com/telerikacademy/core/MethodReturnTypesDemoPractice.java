package com.telerikacademy.core;

import java.util.Scanner;

public class MethodReturnTypesDemoPractice {
    public static void main(String[] args) {
        String name = getValidName();
    }

    private static String getValidName() {
        System.out.print("Please, enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

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
}
