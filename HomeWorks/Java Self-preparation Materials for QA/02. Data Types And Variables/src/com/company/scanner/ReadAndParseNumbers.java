package com.company.scanner;

import java.util.Scanner;

public class ReadAndParseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Takes the whole line from the console as text (for example "123")
        String numberAsText = scanner.nextLine();

        // Transforms or parses the text "123" into the number 123
        int number = Integer.parseInt(numberAsText);

        number = number - 1; //123 - 1 = 122

        // This won't compile as we cannot subtract 1 from a text
        // Operator '-' cannot be applied to 'java.lang.String', 'int'
        // numberAsText = numberAsText -1;

        // "+" operator means concatenate between strings
        // This will produce: "123" + "1" = "1231"
        numberAsText = numberAsText + 1;

        // Print the string
        // Use %s to format it
        System.out.printf("numberAsText value: %s", numberAsText);

        //Use to print new line
        System.out.println();

        // Print the string
        // Use %d to format it
        System.out.printf("number value: %d", number);
    }
}
