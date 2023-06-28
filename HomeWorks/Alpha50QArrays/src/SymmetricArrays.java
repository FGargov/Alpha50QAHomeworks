import java.util.Scanner;

public class SymmetricArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt(); // Тук ще го парсне към Int, но не преминава на нов ред и това може да е проблем при четенето от конзолата.
        int n = Integer.parseInt(scanner.nextLine()); // Тук ще го парсне към Int и преминава четенето на нов ред.

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            boolean symmetric = true;

            for (int j = 0; j < input.length / 2; j++) {
                if (!input[j].equals(input[input.length - 1 - j])) {
                    symmetric = false;
                    break;
                }
            }

            //System.out.println(symmetric ? "Yes" : "No"); //работи и при двете
           if (symmetric) {
                System.out.printf("Yes%n");
            }
            else {
                System.out.printf("No%n");
            }
        }
    }
}
