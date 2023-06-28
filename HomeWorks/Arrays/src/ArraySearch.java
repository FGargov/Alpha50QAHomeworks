import java.util.Scanner;

public class ArraySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");

        StringBuilder missingNums = new StringBuilder();

        for (int currentNumber = 1; currentNumber <= input.length; currentNumber++) {
            boolean isFound = false;

            for (String item : input) {
                if (currentNumber == Integer.parseInt(item)) {
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                if (missingNums.length() > 0) {
                    missingNums.append(',');
                }
                missingNums.append(currentNumber);
            }
        }

        System.out.println(missingNums);
    }
}
