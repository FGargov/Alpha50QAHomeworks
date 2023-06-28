import java.math.BigInteger;

public class BigIntegerExample {
    public static void main(String[] args) {
        BigInteger bigInteger1 = new BigInteger("12345678901234567890");
        BigInteger bigInteger2 = new BigInteger("98765432109876543210");

        BigInteger sum = bigInteger1.add(bigInteger2);
        BigInteger product = bigInteger1.multiply(bigInteger2);

        System.out.println("Сумата е: " + sum);
        System.out.println("Произведението е: " + product);
    }
}