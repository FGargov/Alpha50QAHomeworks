import java.util.Scanner;

public class ForestRoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int height = 2 * n - 1;

        for (int row = 0; row < height; row++) {
            int col = (row < n) ? row : height - row - 1;
            for (int j = 0; j < n; j++) {
                if (j == col) {
                    System.out.print("**");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
