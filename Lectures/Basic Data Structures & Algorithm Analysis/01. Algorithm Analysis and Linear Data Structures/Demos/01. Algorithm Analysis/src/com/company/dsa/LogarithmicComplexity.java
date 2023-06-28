package com.company.dsa;

public class LogarithmicComplexity {
    public static void main(String[] args) {

    }

    // You are given a rope that is n meters long.
    // How many times you should fold it to become less than 1 meter?
    static int foldingRope(int n) {
        int foldingCounter = 0;
        while (n > 1) {
            foldingCounter++;
            n /= 2;
        }
        return foldingCounter;
    }
}
