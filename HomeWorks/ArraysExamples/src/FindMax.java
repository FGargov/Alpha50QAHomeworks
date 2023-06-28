import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //Enter count of numbers:
        int count = Integer.parseInt(scn.nextLine());

        // Read Array
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            // For readability start numbers from 1
            // Still, the array's index ALWAYS starts from 0
            // Enter number:
            int nextNumber = Integer.parseInt(scn.nextLine());
            numbers[i] = nextNumber;
        }

        // Find Max
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        System.out.printf("Max: %d", max);
    }
}
