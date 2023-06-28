import java.util.Scanner;

public class LongestIncreasingSequence {

    public static void main(String[] args) {
        // Create a Scanner object to read input from standard input
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements (N) in the array
        int n = scanner.nextInt();

        // Initialize an array of integers with the given size (N)
        int[] array = new int[n];

        // Read the N integers from standard input and store them in the array
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        // Close the scanner object
        scanner.close();

        // Initialize an array (dp) to store the length of the longest increasing sequence ending at each element
        int[] dp = new int[n];

        // Initialize a variable to store the length of the longest increasing sequence
        int maxLength = 0;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Set the initial length of the longest increasing sequence ending at the current element to 1
            dp[i] = 1;

            // Iterate through the previous elements of the array
            for (int j = 0; j < i; j++) {
                // If the current element is greater than the previous element
                if (array[i] > array[j]) {
                    // Update the length of the longest increasing sequence ending at the current element
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // Update the length of the longest increasing sequence if needed
            maxLength = Math.max(maxLength, dp[i]);
        }

        // Print the length of the longest increasing sequence
        System.out.println(maxLength);
    }
}