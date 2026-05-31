import java.util.Scanner;

public class Task3ArrayRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Введите элементы массива:");
        inputArray(arr, 0, scanner);

        System.out.println("Элементы массива:");
        outputArray(arr, 0);
    }

    public static void inputArray(int[] arr, int index, Scanner scanner) {
        if (index == arr.length) {
            return;
        }
        System.out.print("arr[" + index + "] = ");
        arr[index] = scanner.nextInt();
        inputArray(arr, index + 1, scanner);
    }

    public static void outputArray(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        System.out.print(arr[index] + " ");
        outputArray(arr, index + 1);
    }
}