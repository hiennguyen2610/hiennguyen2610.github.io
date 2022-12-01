import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double weight,height,chiSoBMI;
        System.out.println("Nhập chiều cao: ");
        height = sc.nextDouble();

        System.out.println("Nhập cân nặng: ");
        weight = sc.nextDouble();

        chiSoBMI = weight / ( height * height);
        System.out.println("Chỉ số BMI của bạn là: " + chiSoBMI);

        if (chiSoBMI < 18.5) {
            System.out.println("Thiếu cân");
        } else if (chiSoBMI <= 24.9) {
            System.out.println("Bình thường");
        } else {
            System.out.println("Thừa cân");
        }
    }
}
