public class IteratingArrays {

    public static void main(String[] args) {
        // Create and initialize a 10-element int array
        int[] array = new int[10];

        // Set each element to hold its index
        for (int index = 0; index < array.length; index++) {
            array[index] = index;
        }

        // Print the array
        System.out.println("Original array: ");
        for (int number : array) {
            System.out.println(number + " ");
        }

        System.out.println();

        // Assign value -1 to the odd elements
        for (int index = 1; index < array.length; index += 2) {
            array[index] = -1;
        }

        // Print the array
        System.out.println("Modified array: ");
        for (int number : array) {
            System.out.println(number + " ");
        }

        System.out.println();
    }
}