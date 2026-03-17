package lr2;

public class Task2SnakeMatrix {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;

        int[][] matrix = new int[rows][cols];
        int value = 1;

        // заполняем "змейкой"
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) { // чётные строки: слева направо
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = value++;
                }
            } else { // нечётные строки: справа налево
                for (int j = cols - 1; j >= 0; j--) {
                    matrix[i][j] = value++;
                }
            }
        }

        // вывод матрицы
        System.out.println("Матрица 5x5, заполненная змейкой:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
