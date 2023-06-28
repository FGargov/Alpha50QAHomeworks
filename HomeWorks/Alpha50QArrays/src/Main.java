public class Main {
    public static void main(String[] args) {
        //Multidimensional arrays
        int[][] matrix1 = new int[3][2];
        int[][] matrix2 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        matrix2[0][1] = 20;
        matrix2[1][0] = 234;

        System.out.println(matrix2[2][0]);
        System.out.println(matrix2[2][1]);

        for (int row = 0; row < matrix2.length; row++) {
            for (int col = 0; col < matrix2[0].length; col++) {
                System.out.printf("%d ", matrix2[row][col]);
            }
            System.out.println();
        }

        //С foreach кода е много по четим, когато трябва да изпринтим матрица на конзолата.
        // Минуса е че можем само да четем стойността на матрицата и не може да ги променяме.
        for (int[] rowArray : matrix2) {
            for (int element : rowArray) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
    }
}