package com.company.operators;

public class AssignmentOperators {
    public static void main(String[] args) {
        int x = 6;
        int y = 4;
        System.out.println(y *= 2); // 8
        int z = y = 3;              // y=3 and z=3
        System.out.println(z);      // 3
        System.out.println(x ++);   // first prints x (6) and THEN increments it to 7
        System.out.println(x += 3); // 10
        System.out.println(x /= 2); // 5
    }

}
