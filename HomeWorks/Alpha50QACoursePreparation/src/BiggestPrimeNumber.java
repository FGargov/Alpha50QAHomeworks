import java.util.Scanner;

public class BiggestPrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int biggestPrime = -1;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                biggestPrime = i;
            }
        }

        System.out.println(biggestPrime);
    }
}
