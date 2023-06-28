package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        /*var tomorrow = LocalDate.now().plusDays(1);
        var issue = new Issue("App flow tests?", "We need to test the App!", tomorrow);
        var task = new Task("Test the application flow", "Pesho", tomorrow);

        Board board = new Board();

        board.addItem(issue);
        board.addItem(task);
        System.out.println(board.totalItems()); // 2*/


        /*Task task = new Task("Test the application flow", "Pesho", LocalDate.now().plusDays(1));
        task.advanceStatus();
        task.advanceStatus();
        task.setAssignee("Gosho");
        task.displayHistory();
*/

        Issue issue = new Issue(
                "App flow tests?",
                "We need to test the App!",
                LocalDate.now().plusDays(1));
        issue.advanceStatus();
        issue.setDueDate(issue.getDueDate().plusDays(1));
        issue.displayHistory();


        /*LocalDate tomorrow = LocalDate.now().plusDays(1);
        Issue issue = new Issue("App flow tests?", "We need to test the App!", tomorrow);
        Task task = new Task("Test the application flow", "Pesho", tomorrow);

        Board board = new Board();

        board.addItem(issue);
        board.addItem(task);
        System.out.println(board.totalItems()); // 2*/
    }
}
