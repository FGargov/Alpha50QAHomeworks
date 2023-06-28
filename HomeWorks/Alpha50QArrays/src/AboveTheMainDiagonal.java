import java.util.Scanner;

public class AboveTheMainDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long sum = 0;

        for (int row = 0; row < n; row++) {
            for (int col = row + 1; col < n; col++) {
                sum += (long) Math.pow(2, row + col); // правим го на long защото гърми на проверката заради голямо число
            }
        }

        System.out.println(sum);
    }
}
