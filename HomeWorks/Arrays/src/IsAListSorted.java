import java.util.Arrays;
import java.util.Scanner;

public class IsAListSorted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++)
        {
            String[] input = scanner.nextLine().split(",");
            int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            boolean sorted = true;
            for (int j = 1; j < numbers.length; j++)
            {
                if (numbers[j] < numbers[j - 1])
                {
                    sorted = false;
                    break;
                }
            }

            System.out.println(Boolean.toString(sorted).toLowerCase());
        }
    }
}
