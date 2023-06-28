package com.company.switchstatement;

import java.util.Scanner;

public class SwitchMultipleLabels {
    public static void main(String[] args) {
        System.out.print("Please enter some animal: ");

        Scanner scanner = new Scanner(System.in);
        String animal = scanner.next();
        switch (animal) {
            case "dog":
            case "cat":
            case "cow":
                System.out.println("MAMMAL");
                break;
            case "crocodile":
            case "tortoise":
            case "snake":
                System.out.println("REPTILE");
                break;
            case "hawk":
            case "sparrow":
            case "dove":
                System.out.println("BIRD");
                break;
            default:
                System.out.println("I don't know this animal!");
                break;
        }
    }
}
