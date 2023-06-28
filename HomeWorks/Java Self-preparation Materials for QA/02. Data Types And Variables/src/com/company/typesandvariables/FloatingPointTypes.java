package com.company.typesandvariables;

public class FloatingPointTypes {
    public static void main(String[] args) {
        float floatPi = 3.141592653589793238f;
        double doublePi = 3.141592653589793238;

        // Print on the console declared variables
        // Use %.20f for floating-point numbers, printing 20 digits after the point
        // Use %n for new line
        System.out.printf("Float PI  is: %.20f%n", floatPi);
        System.out.printf("Double PI is: %.20f%n", doublePi);

        // Example of comparison abnormality
        double f1 = 1.0f;
        double f2 = 0.33f;
        double sum = 1.33f;
        boolean equal = (f1 + f2 == sum);

        // Print on the console declared variables
        // Use %.20f for floating-point numbers, printing 20 digits after the point
        // Use %s for text (boolean variable will be printed as word - "true" or "false")
        // Use %n for new line
        System.out.printf(
                "Float calculation: f1 + f2 = %.20f  sum=%.20f  equal=%s%n",
                f1 + f2,
                sum,
                equal);
    }
}
