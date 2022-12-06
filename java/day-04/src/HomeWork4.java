import java.util.Arrays;
import java.util.Scanner;

public class HomeWork4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        while (!isQuit) {
            showMenu();
            System.out.println("Nhập lựa chọn: ");
            option = sc.nextInt();
            switch (option) {
                case 1: {
                    baitap1();
                    break;
                }
                case 2: {
                    baitap2();
                    break;
                }
                case 3: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }

    public static void baitap1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập họ và tên: ");
        String fullName = sc.nextLine();

        // Chuyển chuỗi thành mảng kí tự:
        char[] arr = fullName.toCharArray();
        boolean space = true;

        // Duyêt mảng
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                if (space) {
                    arr[i] = Character.toUpperCase(arr[i]);
                    space = false;
                }
            } else {space = true;}
        }

        fullName = String.valueOf(arr);
        System.out.println("Họ và tên: " + fullName);
    }
    public static void baitap2() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        System.out.print("Nhập số phần tử trong mảng: ");
        int index = sc.nextInt();
        int[] arr = new int[index];

            // Thêm các phần tử vào mảng
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập vào phần tử tại index " + i + " là: ");
            int value = sc.nextInt();
            arr[i] = value;
        }

        while (!isQuit) {
            showMenu1();
            System.out.print("Nhập lựa chọn: ");
            option = sc.nextInt();

            // Chọn menu
            switch (option) {
                case 1: {
                    System.out.println("Thực hiện chức năng 1: In mảng ra màn hình");
                    for (int i = 0; i < arr.length; i++) {}
                    System.out.println(Arrays.toString(arr));
                    break;
                }
                case 2: {
                    System.out.println("Tăng các phần tử là số chẵn lên 1 đơn vị");
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] % 2 == 0) {
                            arr[i] += 1;
                        }
                    }
                    System.out.println("Mảng sau khi tăng các số chẵn lên 1 đơn vị là: ");
                    System.out.println(Arrays.toString(arr));
                    break;
                }
                case 3: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }
            // Menu
    public static void showMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Chọn bài 1");
        System.out.println("2 - CHọn bài 2");
        System.out.println("3 - Thoát\n");
    }

            // Menu bài 2
    public static void showMenu1() {
        System.out.println("\nXin chọn các chức năng sau:");
        System.out.println("1 - In mảng ra màn hình");
        System.out.println("2 - Thay đổi các phần tử là số chẵn trong mảng thì tăng các phần tử đó lên 1 đơn vị");
        System.out.println("3 - Thoát\n");
    }
}
