public class ReverseArray {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};

        // Get array size
        int length = array.length;

        // Declare and create the reversed array
        int[] reversed = new int[length];

        // Initialize the reversed array
        // Start from last element in the array
        int reversed_idx = 0;
        for (int index = length - 1; index >= 0; index--) {
            reversed[reversed_idx] = array[index];
            reversed_idx++;
        }

        // Print the reversed array elements
        for (int index = 0; index < length; index++) {
            System.out.println(reversed[index]);
        }
    }
}
