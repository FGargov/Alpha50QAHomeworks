package com.company.typesandvariables;

public class IntegerTypes {
    public static void main(String[] args) {
        byte centuries = 20;    // Usually a small number
        short years = 2000;
        int days = 730480;
        long hours = 17531520; // May be a very big number

        // Print on the console declared variables
        // Use %d for decimal numbers
        // Use %n for new line
        System.out.printf(
                "%d centuries is %d years, or %d days, or %d hours.",
                centuries,
                years,
                days,
                hours);
    }
}
