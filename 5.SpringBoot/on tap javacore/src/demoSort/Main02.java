package demoSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        // nhập mảng
        System.out.println("Nhập số phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = new Scanner(System.in).nextLine();
        }

        System.out.println(Arrays.toString(arr));

        // sắp xếp
        for (int i = 0; i < n -1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i].compareToIgnoreCase(arr[j]) > 0) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // in kết quả
        System.out.println(Arrays.toString(arr));
    }
}

