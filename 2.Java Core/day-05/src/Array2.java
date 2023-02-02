import java.util.Arrays;
import java.util.Scanner;

public class Array2 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};

        int[][] numbersOther = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        for (int i = 0; i < numbersOther.length; i++) {
            System.out.println(Arrays.toString(numbersOther[i]));
            for (int j = 0; j < numbersOther[i].length; j++) {
                System.out.println(numbersOther[i][j]);
            }
        }
        System.out.println(" Sử dụng for each");
        for (int[] row : numbersOther) {
            for (int number : row) {
                System.out.println(number);
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số hàng (row): ");
        int row = sc.nextInt();

        System.out.println("Nhập vào số cột (col):");
        int col = sc.nextInt();

        int[][] array = new int[row][col];

        // Nhập thông tin mảng
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập vào phần tử [%d][%d]", i, j);
                array[i][j] = sc.nextInt();
            }
        }

        // In ra mảng ở dạng ma trận
        for (int[] subArray : array) {
            for (int number : subArray) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
