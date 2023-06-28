import java.util.Scanner;

public class ArraySort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] tokens = input.split(",");
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        int zeroCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                zeroCount++;
            } else if (zeroCount > 0) {
                numbers[i - zeroCount] = numbers[i];
                numbers[i] = 0;
            }
        }
        System.out.println(String.join(",", convertIntArrayToStringArray(numbers)));
    }

    private static String[] convertIntArrayToStringArray(int[] numbers) {
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }
        return result;
    }
}
