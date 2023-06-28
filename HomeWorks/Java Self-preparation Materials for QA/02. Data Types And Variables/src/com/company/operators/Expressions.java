package com.company.operators;

public class Expressions {
    public static void main(String[] args) {
        int r = (150 - 20) / 2 + 5;
        System.out.printf("r = %d%n", r); // 70

        // Expression for calculation of circle area
        double surface = Math.PI * r * r;
        System.out.printf("surface = %f%n", surface); // 15393,804003

        // Expression for calculation of circle perimeter
        double perimeter = 2 * Math.PI * r;
        System.out.printf("perimeter = %.12f%n", perimeter); // 439,822971502571

        // Expression of type int (evaluated at compile time)
        int a = 2 + 3; // a = 5
        System.out.printf("a = %d%n", a);

        // Expression of type int (evaluated at runtime)
        int b = (a + 3) * (a - 4) + (2 * a + 7) / 4;  // b = 12
        System.out.printf("b = %d%n", b);

        // Expression of type bool (evaluated at runtime)
        boolean greater = (a > b) || ((a == 0) && (b == 0)); // greater  =  false
        System.out.printf("greater = %s%n", greater);

        // Expression of type double (evaluated at runtime)
        double c = (double) (a + b) / b; // c = 1.416666666666667
        System.out.printf("c = %.15f%n", c);

        // Expression of type double (evaluated as int first)
        double d = (double) ((a + b) / b); // d = 1
        System.out.printf("d = %.2f%n", d);
    }
}
