import java.util.Scanner;

public class WhilePractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean isQuit = false;
        while (!isQuit) {
            System.out.print("Nhập vào số bất kỳ: ");
            number = sc.nextInt();
            if (number != 0) {
                System.out.println("Số vừa nhập là: " + number);
                isQuit = true;
            } else {
                System.out.println("Số phải khác 0. Nhập lại!");
            }
        }
    }
}
