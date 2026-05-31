package lr4;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Task2MatrixColumnRandom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

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

            System.out.println("Матрица " + rows + "x" + cols
                    + ", заполненная случайными числами от -9 до 9:");

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = random.nextInt(19) - 9; // диапазон [-9; 9]
                    System.out.printf("%4d", matrix[i][j]);
                }
                System.out.println();
            }

            System.out.print("Введите номер столбца для вывода (1.." + cols + "): ");
            int colNumber = scanner.nextInt(); // возможен InputMismatchException

            if (colNumber < 1 || colNumber > cols) {
                System.out.println("Ошибка: столбца с таким номером не существует.");
                return;
            }

            int colIndex = colNumber - 1;

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