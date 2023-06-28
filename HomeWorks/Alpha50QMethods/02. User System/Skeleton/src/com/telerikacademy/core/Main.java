package com.telerikacademy.core;

import java.util.Scanner;

public class Main {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLACK = "\u001B[30m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[][] usersData = new String[4][2];

        while (!command.equals("end")) {
            String[] commandArgs = command.split(" ");

            switch (commandArgs[0]) {
                case "register":
                    registerUser(commandArgs, usersData);
                    break;

                case "delete":
                    deleteUser(commandArgs, usersData);
                    break;
            }

            command = scanner.nextLine();
        }
    }

    public static void registerUser(String[] commandArgs, String[][] usersData) {
        if (commandArgs.length < 3) {
            printErrorMessage("Too few parameters.");
            return;
        }

        String username = commandArgs[1];
        String password = commandArgs[2];

        if (validateUsername(username) || (validatePassword(password)) || usernameExist(usersData, username)) {
            return;
        }

        int freeSlotIndex = -1;
        for (int i = 0; i < usersData.length; i++) {
            if (usersData[i][0] == null) {
                freeSlotIndex = i;
            }
        }

        if (freeSlotIndex == -1) {
            printErrorMessage("The system supports a maximum number of 4 users.");
            return;
        }

        usersData[freeSlotIndex][0] = username;
        usersData[freeSlotIndex][1] = password;

        System.out.println(ANSI_GREEN + "Registered user." + ANSI_RESET);
    }

    public static void printErrorMessage(String message) {

        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    private static boolean validateUsername(String username) {
        if (username.length() < 3) {
            printErrorMessage("Username must be at least 3 characters long.");
            return true;
        }
        return false;
    }

    private static boolean validatePassword(String password) {
        if (password.length() < 3) {
            printErrorMessage("Password must be at least 3 characters long.");
            return true;
        }
        return false;
    }

    private static boolean usernameExist(String[][] usersData, String username) {
        for (String[] userData : usersData) {
            if (username.equals(userData[0])) {
                System.out.println(ANSI_RED + "Username already exists." + ANSI_RESET);
                return true;
            }
        }
        return false;
    }

    public static void deleteUser(String[] commandArgs, String[][] usersData) {
        if (commandArgs.length < 3) {
            printErrorMessage("Too few parameters.");
            return;
        }

        String username = commandArgs[1];
        String password = commandArgs[2];

        if (validateUsername(username)) return;

        if (validatePassword(password)) return;

        int accountIndex = -1;
        for (int i = 0; i < usersData.length; i++) {
            if (username.equals(usersData[i][0]) && password.equals(usersData[i][1])) {
                accountIndex = i;
            }
        }

        if (accountIndex == -1) {
            printErrorMessage("Invalid account/password.");
            return;
        }

        usersData[accountIndex][0] = null;
        usersData[accountIndex][1] = null;

        System.out.println(ANSI_GREEN + "Deleted account." + ANSI_RESET);
    }
}

//isValidArgumentLength - да разбера какво точно направи трейнера.