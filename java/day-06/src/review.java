import java.util.Arrays;
import java.util.Scanner;

public class review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số phần tử trong mảng: ");
        int index = sc.nextInt();
        int[] arr = new int[index];
        int sumArr = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập vào phẩn tử tại vị trí index " + i + ": ");
            int value = sc.nextInt();
            arr[i] = value;
        }

        boolean isQuit = false;
        while (!isQuit) {
            System.out.println("Nhập lựa chọn: ");
            int option = sc.nextInt();
            switch (option) {
                case 1: {
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println("Phần tử tại vị trí " + i + " là: " + arr[i]);
                    }
                    System.out.println(Arrays.toString(arr));
                    break;
                }

                case 2: {
                    for (int i = 0; i < arr.length; i++) {
                        sumArr += arr[i];
                    }
                    System.out.println("Tổng các phần tử trong mảng là: " + sumArr);
                    break;
                }
                case 3: {
                    int minNumber = arr[0];
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] < minNumber) {
                            minNumber = arr[i];
                        }
                    }
                    System.out.println("Giá trị nhỏ nhất trong mảng là: " + minNumber);
                    break;
                }
                case 4: {
                    int numEvenAmount = 0;
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] % 2 == 0) {
                            numEvenAmount += 1;
                        }
                    }
                    System.out.println("Số lượng phần tử chẵn trong mảng là: " + numEvenAmount);
                    break;
                }
                case 5: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Không có lựa chọn nào hợp lệ");
                }
            }
        }
    }
}
