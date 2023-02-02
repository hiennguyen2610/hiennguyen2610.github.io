import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số hàng (row): ");
        int row = sc.nextInt();

        System.out.print("Nhập vào số cột (col): ");
        int col = sc.nextInt();

        int[][] array = new int[row][col];

        // Nhập thông tin mảng
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập vào phần tử [%d][%d]", i, j);
                array[i][j] = sc.nextInt();
            }
        }

        // In thông tin mảng
        for (int[] subArray : array) {
            for (int number : subArray) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

        // Liệt kê các phần tử nằm trên đường chéo chính
        System.out.println("Phần tử nằm trên đường chéo chính là: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == j) {
                    System.out.println(array[i][j]);
                }
            }
        }

        // Tạo thêm 1 mảng 2 chiều khác và cộng 2 mảng lại

        int[][] newArr = new int[row][col];

        // Nhập thông tin mảng
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập vào phần tử [%d][%d]", i, j);
                newArr[i][j] = sc.nextInt();
            }
        }

        // In thông tin mảng
        for (int[] newArray : newArr) {
            for (int newNumber : newArray) {
                System.out.print(newNumber + " ");
            }
            System.out.println();
        }

        // Mảng sau khi cộng
        System.out.println("Mảng sau khi cộng là:");
        int[][] arrTotal = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arrTotal[i][j] = array[i][j] + newArr[i][j];
            }
        }

        // In thông tin mảng
        for (int[] subArrayTotal : arrTotal) {
            for (int number : subArrayTotal) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
