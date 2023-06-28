package com.telerikacademy.core;

import java.util.Scanner;

public class MainSolutionTelerik {
    public static void main(String[] args) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String[][] usersData = new String[4][2];

        // main loop
        while (!command.equals("end")) {
            String[] commandArgs = command.split(" ");
            switch (commandArgs[0]) {
                case "register": {
                    registerUser(usersData, commandArgs);
                    break;
                }
                case "delete": {
                    deleteUser(usersData, commandArgs);
                    break;
                }
            }

            // read next command
            command = scanner.nextLine();
        }
    }

    public static void registerUser(String[][] usersData, String[] commandArgs) {
        // validate arguments
        if (!isValidArgumentsCount(commandArgs, 3)) {
            return;
        }

        String username = commandArgs[1];
        String password = commandArgs[2];

        // validate username
        if (!isValidArgumentLength("Username", username, 3)) {
            return;
        }

        // validate password
        if (!isValidArgumentLength("Password", password, 3)) {
            return;
        }

        // check if username exists
        if (usernameExists(usersData, username)) {
            printError("Username already exists.");
            return;
        }

        // find free slot
        int freeSlotIndex = getFreeIndex(usersData);

        // no free slots
        if (freeSlotIndex == -1) {
            printError("The system supports a maximum number of 4 users.");
            return;
        }

        // save user
        usersData[freeSlotIndex][0] = username;
        usersData[freeSlotIndex][1] = password;

        printSuccess("Registered user.");
    }

    public static void deleteUser(String[][] usersData, String[] commandArgs) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";

        // validate arguments
        if (!isValidArgumentsCount(commandArgs, 3)) {
            return;
        }

        String username = commandArgs[1];
        String password = commandArgs[2];

        // validate username
        if (!isValidArgumentLength("Username", username, 3)) {
            return;
        }

        // validate password
        if (!isValidArgumentLength("Password", password, 3)) {
            return;
        }


        // find account to delete
        int accountIndex = findUserIndex(usersData, username, password);


        if (accountIndex == -1) {
            printError("Invalid account/password.");
            return;
        }

        usersData[accountIndex][0] = null;
        usersData[accountIndex][1] = null;

        printSuccess("Deleted account");
    }

    public static boolean isValidArgumentsCount(String[] commandArgs, int minLength) {
        if (commandArgs.length < minLength) {
            printError("Too few parameters.");
            return true;
        }
        return true;
    }

    public static boolean isValidArgumentLength(String inputType, String input, int minLength) {
        if (input.length() < minLength) {
            printError(String.format("%s must be at least %d characters long.", inputType, minLength));
            return false;
        }
        return true;
    }

    public static boolean usernameExists(String[][] usersData, String username) {
        for (int i = 0; i < usersData.length; i++) {
            if (username.equals(usersData[i][0])) {
                return true;
            }
        }
        return false;
    }

    public static int getFreeIndex(String[][] usersData) {
        for (int i = 0; i < usersData.length; i++) {
            if (usersData[i][0] == null) {
                return i;
            }
        }
        return -1;
    }

    public static int findUserIndex(String[][] usersData, String username, String password) {
        for (int i = 0; i < usersData.length; i++) {
            if (username.equals(usersData[i][0]) && password.equals(usersData[i][1])) {
                return i;
            }
        }
        return -1;
    }

    public static void printError(String errorMessage) {
        String ANSI_RED = "\u001B[31m";
        printMessage(ANSI_RED, errorMessage);
    }

    public static void printSuccess(String successMessage) {
        String ANSI_GREEN = "\u001B[32m";
        printMessage(ANSI_GREEN, successMessage);
    }

    public static void printMessage(String ansiColor, String message) {
        String ANSI_RESET = "\u001B[0m";
        System.out.println(ansiColor + message + ANSI_RESET);

    }
}