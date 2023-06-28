package com.company.oop.days;

public class Main {

    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.WED;
        System.out.println(day); // Wed

        // Save all possible values to an array
        DayOfWeek[] allDays = DayOfWeek.values();

        // Loop over the enum
        System.out.println("Days of the week: ");
        for (DayOfWeek dayOfWeek : allDays) {
            System.out.printf("%s, ", dayOfWeek);
        }
    }
}


