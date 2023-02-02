import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // Khởi tạo đối tượng scanner
        Scanner sc = new Scanner(System.in);

        // Nhập tên
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();

        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();

        System.out.println("Nhập tuổi: ");
        int age = sc.nextInt();

        System.out.println("Tên tôi là: " + name + ". Địa chỉ là: " + address + ". Năm nay tôi " + age);
    }
}
