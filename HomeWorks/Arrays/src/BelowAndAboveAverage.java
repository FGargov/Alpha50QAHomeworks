// Import required classes
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BelowAndAboveAverage {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        // Read the input as a single line
        String input = scanner.nextLine();
        // Split the input into tokens based on the comma delimiter
        String[] tokens = input.split(",");
        // Initialize an integer array to store the numbers
        int[] numbers = new int[tokens.length];

        // Convert the string tokens into integers and store them in the numbers array
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }

        // Calculate the sum of the numbers
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // Calculate the average of the numbers
        double average = sum / numbers.length;
        // Initialize two lists to store numbers below and above the average
        List<Integer> below = new ArrayList<>();
        List<Integer> above = new ArrayList<>();

        // Iterate through the numbers and add them to the appropriate list
        for (int num : numbers) {
            if (num < average) {
                below.add(num);
            } else if (num > average) {
                above.add(num);
            }
        }

        // Print the average, numbers below the average, and numbers above the average
        System.out.printf("avg: %.2f%n", average);
        System.out.println("below: " + String.join(",", below.stream().map(String::valueOf).toArray(String[]::new)));
        System.out.println("above: " + String.join(",", above.stream().map(String::valueOf).toArray(String[]::new)));
    }
}
