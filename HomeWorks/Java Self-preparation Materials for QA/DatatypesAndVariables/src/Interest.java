import java.util.Scanner;
public class Interest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = scanner.nextDouble();

        for (int i = 0; i < n; i++) {
            double interest = n * 0.05;
            n += interest;

            System.out.printf("%.2f", n);
        }
    }
}
