// Коментарите на кода са на български език
import java.util.Scanner;

public class Core1BigNumbersTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Четем размерите на двата масива
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int[] num1 = new int[n1];
        int[] num2 = new int[n2];

        // Четем първия масив
        for (int i = 0; i < n1; i++) {
            num1[i] = scanner.nextInt();
        }

        // Четем втория масив
        for (int i = 0; i < n2; i++) {
            num2[i] = scanner.nextInt();
        }

        // Изпълнение на метода за събиране на числата, представени като масиви
        int[] result = addBigNumbers(num1, num2);

        // Извеждане на резултата
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] addBigNumbers(int[] num1, int[] num2) {
        // Определяне на максималната дължина на резултатния масив
        int maxLength = Math.max(num1.length, num2.length);

        // Инициализиране на резултатния масив с максималната дължина + 1 (за евентуално прехвърляне)
        int[] result = new int[maxLength + 1];

        // Променлива за прехвърляне
        int carry = 0;

        // Обхождане на числата и събирането им цифра по цифра
        for (int i = 0; i < maxLength; i++) {
            int digit1 = i < num1.length ? num1[i] : 0;
            int digit2 = i < num2.length ? num2[i] : 0;

            int sum = digit1 + digit2 + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }

        // Добавяне на последното прехвърляне, ако има такова
        if (carry != 0) {
            result[maxLength] = carry;
        }

        // Премахване на водещите нули, ако има такива
        int lastIndex = result.length - 1;
        while (lastIndex > 0 && result[lastIndex] == 0) {
            lastIndex--;
        }
        int[] trimmedResult = new int[lastIndex + 1];
        System.arraycopy(result, 0, trimmedResult, 0, lastIndex + 1);

        return trimmedResult;
    }
}