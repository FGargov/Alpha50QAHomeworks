public class Main {
    public static void main(String[] args)
    {
        String[] array = {"one", "two", "three", "four"};

        // Process all elements of the array
        for (int index = 0; index < array.length; index++) {
            // Print each element on a separate line
            System.out.printf("element[%d] = %s%n", index, array[index]);
        }
    }
}