import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numberStrings = scanner.nextLine().split(", ");
        int[] numbers = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++)
        {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }
        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = i + 1; j < numbers.length; j++)
            {
                if (numbers[j] > numbers[i])
                {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        String[] nubmersAsString = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nubmersAsString[i] = Integer.toString(numbers[i]);
        }

        String output = String.join(",", nubmersAsString);
        System.out.println(output);
    }
}
