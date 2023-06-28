import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*int[] numbers = new int[] {7, 2, 3, 4, 5, 6};
        String[] languages = new String[] {"C#", "Java", "Python"};
        System.out.println(languages.length);
        System.out.println(numbers.length);

        int firstElement = numbers[0];
        int lastElement = numbers[numbers.length - 1];
        System.out.println(firstElement);
        System.out.println(lastElement);
        //System.out.println(numbers[6]);
        numbers[2] = 54;*/

        //Looping array
        /*String[] courses = { "OOP", "HQC", "Databases", "Spring MVC"};
        for (int i = 0; i <= courses.length - 1; i++) {
            String course = courses[i];
            System.out.printf("At index %d: %s%n", i, course);
        }*/

        /*char[] letters = { 'a', 'b', 'c', 'd', 'e'};
        for (int i = letters.length - 1; i >= 0 ; i--) {
            System.out.printf("At index %d: %s%n", i, letters[i]);
        }*/

        /*int[] nums = {6, 2, 3, 11, 5, 7};
        System.out.println("At even indicates: ");
        for (int i = 0; i < nums.length; i+=2) {
            System.out.printf("At index %d: %d%n", i, nums[i]);
        }*/
        
        /*int[] numbers2 = {3, 4, 2, 78, 123};
        for (int number:numbers2) {
            System.out.println(number);
        }*/

        //Arrays input

        //Read from the console the length of the array
        Scanner scanner = new Scanner(System.in);
        /*String line = scanner.nextLine();
        int count = Integer.parseInt(line);

        //Create the array and reach each elemetn
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }*/

        //Split elements of the array and parse the elements to integer
        /*String line = scanner.nextLine();
        String[] elements = line.split(" ");
        int[] numbersSplit = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            numbersSplit[i] = Integer.parseInt(elements[i]);
        }*/

        //Print each element on new line
      /*  String[] progrLanguages = {"C#", "Java", "Python", "JavaScript"};
        for (int i = 0; i < progrLanguages.length; i++) {
            System.out.println(progrLanguages[i]);
        }
        for (String language:
             progrLanguages) {
            System.out.println(language);
        }*/

        //String join
        /*String joinedString = String.join(", ", "How", "To", "Do", "In", "Java");
        System.out.println(joinedString);*/

        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        String[] numbersAsString = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersAsString[i] = Integer.toString(numbers[i]);
        }
        String output = String.join(", ", numbersAsString);
        System.out.println(output);
    }
}