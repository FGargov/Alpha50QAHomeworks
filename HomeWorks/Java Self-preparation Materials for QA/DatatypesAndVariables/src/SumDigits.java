import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i <= 3; i++) {
            sum += n % 10;
            n /= 10;
        }

        System.out.println(sum);
    }
}
