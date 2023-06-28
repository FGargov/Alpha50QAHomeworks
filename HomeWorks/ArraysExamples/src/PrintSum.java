import java.util.Scanner;

public class PrintSum {
    public static void main(String[] args) {
        // Read Array
        Scanner scn = new Scanner(System.in);
        // Enter numbers on a single line, separated by a space:
       /* String[] numbersAsStrings = scn.nextLine().split(" ");

        // Find Sum
        int sum = 0;
        for (int i = 0; i < numbersAsStrings.length; i++) {
            int number = Integer.parseInt(numbersAsStrings[i]);
            sum += number;
        }

        // Print Formatted Array
        String formattedArray = String.join(" + ", numbersAsStrings);
        System.out.printf("%s = %d%n", formattedArray, sum);*/

        String[] numbersAsString = scn.nextLine().split(" ");
        int sum = 0;
        for (int i = 0; i < numbersAsString.length; i++) {
            int number = Integer.parseInt(numbersAsString[i]);
            sum += number;
        }
        String formattedArray = String.join(" + ", numbersAsString);
        System.out.printf("%s = %d%n", formattedArray, sum);
    }
}
