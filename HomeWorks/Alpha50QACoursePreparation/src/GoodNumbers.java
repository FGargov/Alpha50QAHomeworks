import java.util.Scanner;

public class GoodNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        int goodNumbersCount = 0;

        for (int i = a; i <= b; i++) {
            int temp = i;
            boolean isGood = true;

            while (temp > 0) {
                int digit = temp % 10;

                if (digit == 0 || i % digit != 0) {
                    isGood = false;
                    break;
                }

                temp /= 10;
            }

            if (isGood) {
                goodNumbersCount++;
            }
        }

        System.out.println(goodNumbersCount);
    }
}
