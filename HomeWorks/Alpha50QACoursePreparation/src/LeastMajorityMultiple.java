import java.util.Scanner;

public class LeastMajorityMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();

        int multiple = 1;
        while (true) {
            int divisibleCount = 0;
            if (multiple % a == 0) divisibleCount++;
            if (multiple % b == 0) divisibleCount++;
            if (multiple % c == 0) divisibleCount++;
            if (multiple % d == 0) divisibleCount++;
            if (multiple % e == 0) divisibleCount++;

            if (divisibleCount >= 3) {
                break;
            }
            multiple++;
        }

        System.out.println(multiple);
    }
}
