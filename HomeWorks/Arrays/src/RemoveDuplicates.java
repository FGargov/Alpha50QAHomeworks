import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int n = input.length;
        String[] output = new String[n];
        int k = 0;

        Set<String> uniqueStrings = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!uniqueStrings.contains(input[i])) {
                uniqueStrings.add(input[i]);
                output[k++] = input[i];
            }
        }

        output = Arrays.copyOf(output, k);
        System.out.println(String.join(",", output));
    }
}
