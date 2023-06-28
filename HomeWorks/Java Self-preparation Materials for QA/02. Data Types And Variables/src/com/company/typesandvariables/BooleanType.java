package com.company.typesandvariables;

public class BooleanType {
    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 2;

        boolean greater = (n1 > n2);
        System.out.println(greater);  // false

        //notice how lowercase L and digit one look the same
        //be careful when naming variables
        boolean equalN1To1 = (n1 == 1);
        System.out.println(equalN1To1);    // true
    }
}
