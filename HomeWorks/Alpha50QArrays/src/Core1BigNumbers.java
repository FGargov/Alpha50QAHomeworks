import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Core1BigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитане на дължините на двата масива
        int length1 = scanner.nextInt();
        int length2 = scanner.nextInt();

        // Прочитане на първия масив и създаване на число с BigInteger
        BigInteger num1 = BigInteger.ZERO;
        for (int i = 0; i < length1; i++) {
            int digit = scanner.nextInt();
            num1 = num1.add(BigInteger.valueOf(digit).multiply(BigInteger.TEN.pow(i)));
        }

        // Прочитане на втория масив и създаване на число с BigInteger
        BigInteger num2 = BigInteger.ZERO;
        for (int i = 0; i < length2; i++) {
            int digit = scanner.nextInt();
            num2 = num2.add(BigInteger.valueOf(digit).multiply(BigInteger.TEN.pow(i)));
        }

        // Събиране на числата
        BigInteger sum = num1.add(num2);

        // Превръщане на резултата обратно в масив от цифри
        int[] result = Arrays.stream(sum.toString().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        // Обръщане на резултатния масив, за да съответства на изходния формат
        for (int i = 0; i < result.length / 2; i++) {
            int temp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = temp;
        }

        // Извеждане на резултата
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i < result.length - 1 ? " " : "\n"));
        }
    }
}
