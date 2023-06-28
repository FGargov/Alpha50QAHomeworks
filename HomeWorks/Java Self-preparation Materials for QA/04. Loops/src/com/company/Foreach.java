package com.company;

public class Foreach {
    public static void main(String[] args) {
        String[] days = new String[]{
                "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"
        };

        //Print each element from the days array of strings
        for (String day : days) {
            System.out.println(day);
        }
    }
}
