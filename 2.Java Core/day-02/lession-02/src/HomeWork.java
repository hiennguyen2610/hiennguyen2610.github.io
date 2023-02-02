import java.util.Scanner;

public class HomeWork {

    // Bài 1
    public static void main(String[] args) {
        Scanner hcn = new Scanner(System.in);

        // Nhập chiều dài
        System.out.println("Nhập chiều dài hình chữ nhật: ");
        double length = hcn.nextDouble();

        // Nhập chiều rộng
        System.out.println("Nhập chiều rộng hình chữ nhật: ");
        double width = hcn.nextDouble();

        // Tính toán
        double area = length * width;
        double perimeter = (length + width) * 2;

        // In ra kết quả
        System.out.println("Diện tích hình chữ nhật là: " + area);
        System.out.println("Chu vi hình chữ nhật là: " + perimeter);
    }
}
