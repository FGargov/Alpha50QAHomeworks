package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
       /* var tomorrow = LocalDate.now().plusDays(1);
        var issue = new Issue("App flow tests?", "We need to test the App!", tomorrow);
        var task = new Task("Test the application flow", "Pesho", tomorrow);

        Board board = new Board();

        board.addItem(issue);
        board.addItem(task);
        System.out.println(board.totalItems()); // 2*/



       /* *//* Main.java *//*
        Task task = new Task("Write unit tests", "Pesho", LocalDate.now().plusDays(1));
        Issue issue = new Issue("Review tests", "Someone must review Pesho's tests.", LocalDate.now().plusDays(1));

        Board board = new Board();

        board.addItem(task);  // treating type Task as type BoardItem
        board.addItem(issue); // treating type Issue as type BoardItem*/



        /*LocalDate tomorrow = LocalDate.now().plusDays(1);
        Task task = new Task("Write unit tests", "Pesho", tomorrow);
        Issue issue = new Issue("Review tests", "Someone must review Pesho's tests.", tomorrow);

        Board board = new Board();

        board.addItem(task);
        board.addItem(issue);

        ConsoleLogger logger = new ConsoleLogger();
        board.displayHistory(logger); // pass a ConsoleLogger type where an Logger is expected*/



        LocalDate tomorrow1 = LocalDate.now().plusDays(1);
        BoardItem task1 = new Task("Write unit tests", "Pesho", tomorrow1);
        System.out.println(task1.viewInfo());

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        Task task = new Task("Write unit tests", "Pesho", tomorrow);
        Issue issue = new Issue("Review tests", "Someone must review Pesho's tests.", tomorrow);

        System.out.println(task.viewInfo());
        System.out.println(issue.viewInfo());

    }

}
