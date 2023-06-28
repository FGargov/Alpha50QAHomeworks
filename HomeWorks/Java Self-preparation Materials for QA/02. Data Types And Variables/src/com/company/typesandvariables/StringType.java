package com.company.typesandvariables;

public class StringType {
    public static void main(String[] args) {
        String firstName = "John";
        String lastName = "Smith";

        // Use %s to format the strings
        // Use %n for new line
        System.out.printf("Hello, %s!%n", firstName);

        // "+" operator concatenates strings
        String fullName = firstName + " " + lastName;

        // Use %s to format the strings
        // Use %n for new line
        System.out.printf("Your full name is %s.%n", fullName);
    }
}
