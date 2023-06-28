public class Formatting {
    public static void main(String[] args) {
        /*int age = 10;
        System.out.printf("My age is %d", age);*/

        int age = 7;
        String name = "Том";
        System.out.printf("My name is %s.%nI am %d years old.%n", name, age);

        double price = 1.66354;
        System.out.printf("The price is %f%n", price);

        double pricePrecision = 1.6664234;
        System.out.printf("The price is %.2f%n", pricePrecision);

        double pricePrecisionTwo = 1.6664234;
        System.out.printf("The price is %.0f", pricePrecisionTwo);
    }
}
