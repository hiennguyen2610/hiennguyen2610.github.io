import java.util.Scanner;

public class MenuDemo {
    public static void main(String[] args) {
            // Object Scanner: lấy thông tin nhập vào từ bàn phím.
        Scanner sc = new Scanner(System.in);
        int option = 0;             // Giá trị nhập vào từ bàn phím
        boolean isQuit = false;     // Cho biết khi nào thoát ra chương trình.

        while (!isQuit) {
            showMenu();

            System.out.print("Nhập lựa chọn : ");
            option = sc.nextInt();

            switch (option) {
                case 1: {
                    doFunctionOne();
                    break;
                }
                case 2: {
                    doFunctionTwo();
                    break;
                }
                case 3: {
                    doFunctionThree();
                    break;
                }
                case 4: {
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
            // Các chức năng có trong ứng dụng:
    public static void doFunctionOne() {
        System.out.println("Thực hiện chức năng 1");
    }

    public static void doFunctionTwo() {
        System.out.println("Thực hiện chức năng 2");
    }

    public static void doFunctionThree() {
        System.out.println("Thực hiện chức năng 3");
    }
            // Menu hướng dẫn sử dụng:
    public static void showMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Chức năng 1");
        System.out.println("2 - Chức năng 2");
        System.out.println("3 - Chức năng 3");
        System.out.println("4 - Thoát\n");
    }
}
