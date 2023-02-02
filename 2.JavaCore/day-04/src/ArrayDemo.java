import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Số phần tử của mảng là: ");
        int index = sc.nextInt();       // Nhập vào số phần tử trong mảng.
        int sumNumber = 0;
        int[] arr = new int[index];     // Khai báo mảng có độ dài nhập vào từ bàn phím.
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nhập vào phần tử tại index:" + i + " là: ");
            int value = sc.nextInt();   // Nhập các phần tử trong mảng
            arr[i] = value;             // Gán các phần tử vào trong mảng
        }
            // Duyệt mảng
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Phần tử tại vị trí " + i + " là: " + arr[i]);
        }
            // In ra thông tin của mảng dưới kiểu dữ liệu String
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            sumNumber += arr[i];
        }
        System.out.println("Tổng các phần tử trong mảng là: " + sumNumber);
        Arrays.sort(arr);       // Sắp xếp lại các phần tử trong mảng theo thứ tự từ nhỏ đến lớn
        System.out.println(Arrays.toString(arr));
    }
}
