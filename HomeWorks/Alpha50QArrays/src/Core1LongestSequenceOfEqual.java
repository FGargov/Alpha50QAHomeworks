import java.util.Scanner;

public class Core1LongestSequenceOfEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int maxLength = 0;
        int currentLength = 1;

        // 2 1 1 2 3 3 2 2 2 1
        for (int i = 1; i < n; i++) {
            if (numbers[i] == numbers[i - 1]) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = 1; // "нулираме", защото няма повече еднакви числа в поредицата в масива.
            }
        }
        // If the current sequence has ended, check if it is longer than the current maximum
        // If it is, update the maximum length
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }

        System.out.println(maxLength);

        /*for (int i = 1; i < n; i++) {
            if (numbers[i] == numbers[i - 1]) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = 1;
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
        }

        System.out.println(maxLength);*/
    }
}
