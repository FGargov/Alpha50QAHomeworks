public class Operators {
    public static void main(String[] args) {
        int squarePerimeter = 17;
        double squareSide = squarePerimeter / 4.0;
        double squareArea = squareSide * squareSide;
        System.out.println(squareSide); // 4.25
        System.out.println(squareArea); // 18.0625

        int n1 = 5;
        int n2 = 4;
        System.out.println(n1 + n2);     // 9
        System.out.println(n1 + n2++);   // 9
        System.out.println(n1 + n2);     // 10
        System.out.println(n1 + (++n2)); // 11
        System.out.println(n1 + n2);     // 11

        System.out.println(11 / 3); // 3
        System.out.println(11 % 3); // 2
        System.out.println(12 / 3); // 4

        System.out.println(11.0 / 3); // 3.66666666666665
        System.out.println(11 / 3.0); // 3.66666666666665
        System.out.println(11 % 3);   // 2
        System.out.println(11 % -3);  // 2
        System.out.println(-11 % 3);  // -2

        System.out.println("1.5 / 0.0 = " + (1.5 / 0.0));   // Infinity
        System.out.println("-1.5 / 0.0 = " + (-1.5 / 0.0)); // -Infinity
        System.out.println("0.0 / 0.0 = " + (0.0 / 0.0));   // NaN

        // This will produce ArithmeticException
        // int x = 0;
        // System.out.println("5 / 0 = " + (5 / x));

        int bigNum = 2000000000;
        int bigSum = 2 * bigNum;    // Integer overflow!
        System.out.println(bigSum); // -294967296

        bigNum = Integer.MAX_VALUE;
        bigNum = bigNum + 1;
        System.out.println(bigNum); // -2147483648
    }
}
