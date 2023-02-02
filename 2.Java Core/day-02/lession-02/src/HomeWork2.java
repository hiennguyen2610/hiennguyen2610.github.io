import java.util.Scanner;

public class HomeWork2 {
    // Bài 2
    public static void main(String[] args) {
        Scanner info = new Scanner(System.in);

        // Nhập tên
        System.out.println("Nhập tên: ");
        String name = info.nextLine();

        // Nhập tuổi
        System.out.println("Nhập tuổi: ");
        int age = info.nextInt();
        info.nextLine();

        // Nhập giới tính
        System.out.println("Nhập giới tính: ");
        String gender = info.nextLine();

        // Nhập địa chỉ
        System.out.println("Nhập địa chỉ: ");
        String address = info.nextLine();


        // In ra kết quả
        System.out.println("Xin chào các bạn, mình là " + name + ". Năm nay mình " + age + ", giới tính " + gender + ". Hiện tại đang sinh sống và làm việc tại " + address);

    }

}
