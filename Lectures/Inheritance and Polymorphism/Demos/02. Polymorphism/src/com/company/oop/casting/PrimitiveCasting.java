package com.company.oop.casting;

public class PrimitiveCasting {
    public static void main(String[] args) {
        //implicit casting from int number - no data can be lost
        double doubleNumber = 25;

        //explicit casting from double to int - all info after the decimal point is lost!
        int intNumber = (int) 3.14;
    }
}
