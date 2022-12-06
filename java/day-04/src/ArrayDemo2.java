import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cột trong mảng 2 chiều: ");
        int col = sc.nextInt();
        System.out.println("Nhập số hàng trong mảng 2 chiều: ");
        int row = sc.nextInt();
        int[][] arr = new int[col][row];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                System.out.print("Nhập phần tử [" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        System.out.println(Arrays.toString(arr));
    }
}
