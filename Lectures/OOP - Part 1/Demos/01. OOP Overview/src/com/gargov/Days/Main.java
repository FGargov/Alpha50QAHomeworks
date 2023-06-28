package com.gargov.Days;

import java.time.DayOfWeek;

public class Main {
    public static void main(String[] args) {
        Days day = Days.WED;
        System.out.println(day);

        Days[] allDays = Days.values();
        for (Days dayOfTheWeek: allDays){
            System.out.printf("%s, ", dayOfTheWeek);
        }
    }
}
