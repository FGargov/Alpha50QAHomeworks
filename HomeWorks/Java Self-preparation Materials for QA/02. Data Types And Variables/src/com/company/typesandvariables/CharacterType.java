package com.company.typesandvariables;

public class CharacterType {
    public static void main(String[] args) {
        char symbol = 'a';
        System.out.printf("This is symbol: %c%n", symbol);

        // Use http://www.asciitable.com/
        // to initialize char variables with ASCII code
        symbol = 98;
        System.out.printf("This is symbol: %c%n", symbol);

        symbol = 65;
        System.out.printf("This is symbol: %c%n", symbol);

        symbol = 249;
        System.out.printf("This is symbol: %c%n", symbol);

        // Get first element of the text that is at position 0 (zero)
        String text = "Hello world!";
        symbol = text.charAt(0);
        System.out.printf("This is symbol: %c%n", symbol);
    }
}
