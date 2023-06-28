package com.company.ifstatement;

import java.util.Scanner;

public class MultipleIfElse {
    public static void main(String[] args) {
        System.out.print("Please enter a character: ");

        Scanner scanner = new Scanner(System.in);
        char ch = scanner.next().charAt(0);

        if (ch == 'A' || ch == 'a') {
            System.out.println("Vowel [ei]");
        } else if (ch == 'E' || ch == 'e') {
            System.out.println("Vowel [i:]");
        } else if (ch == 'I' || ch == 'i') {
            System.out.println("Vowel [ai]");
        } else if (ch == 'O' || ch == 'o') {
            System.out.println("Vowel [ou]");
        } else if (ch == 'U' || ch == 'u') {
            System.out.println("Vowel [ju:]");
        } else {
            System.out.println("Consonant");
        }
    }
}
