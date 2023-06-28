import java.math.BigDecimal;
import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal num = new BigDecimal(scanner.nextLine());

        String numStr = num.toString();
        char[] numChars = numStr.toCharArray();
        int left = 0;
        int right = numChars.length - 1;

        while (left < right) {
            char temp = numChars[left];
            numChars[left] = numChars[right];
            numChars[right] = temp;
            left++;
            right--;
        }

        String reversedNumStr = new String(numChars);
        BigDecimal reversedNum = new BigDecimal(reversedNumStr);
        System.out.println(reversedNum);
    }
}
