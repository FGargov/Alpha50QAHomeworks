import java.util.Scanner;

public class BottleDeposit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int halfLiterBottles = scanner.nextInt();

        int oneLitterBottles = scanner.nextInt();

        double sum = halfLiterBottles * 0.1 + oneLitterBottles * 0.25;

        System.out.printf("%.2f", sum);
    }
}
