package com.company.operators;

public class OtherOperators {
    public static void main(String[] args) {
        String first = "First";
        String second = "Second";
        System.out.println(first + second); // FirstSecond

        String output = "The number is : ";
        int number = 5;
        System.out.println(output + number); // The number is : 5

        int a = 6;
        int b = 4;
        System.out.println(a > b ? "a > b" : "b >= a"); // a>b

        int c = b = 3; // b=3 and c=3
        System.out.println(c); // 3
    }
}
