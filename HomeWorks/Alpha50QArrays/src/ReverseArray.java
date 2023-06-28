import java.util.*;
import java.util.stream.IntStream;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int[] numbers = new int[arr.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        //Reversed array - 3 methods
        // 1
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println();

        //2
        int size = numbers.length;
        int[] reverseSample = IntStream.range(0,size).map(i -> numbers[size-i-1])
                .toArray();

        int counter = 0;
        for (int i : reverseSample) {
            System.out.printf("%d", i);
            if (counter < reverseSample.length - 1) {
                System.out.print(", ");
            }
            counter++;
        }
    }
}
