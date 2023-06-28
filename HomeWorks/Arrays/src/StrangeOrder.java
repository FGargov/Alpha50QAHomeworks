import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrangeOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        int[] numbers = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        List<Integer> negatives = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();

        for (int num : numbers) {
            if (num < 0) {
                negatives.add(num);
            } else if (num == 0) {
                zeros.add(num);
            } else {
                positives.add(num);
            }
        }

        List<Integer> result = new ArrayList<>(negatives);
        result.addAll(zeros);
        result.addAll(positives);

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            output.append(result.get(i));
            if (i != result.size() - 1) {
                output.append(",");
            }
        }
        System.out.println(output.toString());
    }
}