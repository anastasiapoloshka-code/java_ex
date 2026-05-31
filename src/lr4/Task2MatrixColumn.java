package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2MatrixColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите количество строк матрицы: ");
            int rows = scanner.nextInt(); // возможен InputMismatchException

            System.out.print("Введите количество столбцов матрицы: ");
            int cols = scanner.nextInt(); // возможен InputMismatchException

            if (rows <= 0 || cols <= 0) {
                System.out.println("Размеры матрицы должны быть положительными.");
                return;
            }

            int[][] matrix = new int[rows][cols];
            System.out.println("Введите элементы матрицы (" + rows + "x" + cols + "):");

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt(); // возможен InputMismatchException
                }
            }

            System.out.print("Введите номер столбца для вывода (1.." + cols + "): ");
            int colNumber = scanner.nextInt(); // возможен InputMismatchException

            // проверка существования столбца
            if (colNumber < 1 || colNumber > cols) {
                System.out.println("Ошибка: столбца с таким номером не существует.");
                return;
            }

            int colIndex = colNumber - 1; // переход к индексу массива (0..cols-1)

            System.out.println("Столбец №" + colNumber + ":");
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][colIndex]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число.");
        } finally {
            scanner.close();
        }
    }
}