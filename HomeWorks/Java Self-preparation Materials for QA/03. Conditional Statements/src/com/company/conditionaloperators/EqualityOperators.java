package com.company.conditionaloperators;

public class EqualityOperators {
    public static void main(String[] args) {
        int x = 2 * 4;
        int y = 16 / 2;
        System.out.println(x == y);   // true
        System.out.println(x == ++y); // false

        int a = 20;
        int b = 21;
        System.out.println(a != b);   // true
        System.out.println(a != --b); // false
    }
}
