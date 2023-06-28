public class MethodsExamplesAndDemos {
    public static void main(String[] args) {
        //System.out.println("Hello");
       /* printWelcomeMessage();
        printTelerikAcademyAddress();*/

        int[][] matrix = {
                {1,2,3},
                {4,5},
                {6}
        };

        printMessage("Hello, Telerik!");
        printMatrix(matrix);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMatrix(int[][] matrix){
        for (int[] row : matrix) {
            String rowString = "";
                for (int cell : row) {
                rowString += cell + " ";
            }
            System.out.println(rowString.trim());
        }
    }
    /*public static void printWelcomeMessage() {
        System.out.println("Hello, world!");
    }
    public static void printTelerikAcademyAddress() {
        System.out.println("Telerik Academy");
        System.out.println("https://telerikacademy.com/");
    }*/
}
