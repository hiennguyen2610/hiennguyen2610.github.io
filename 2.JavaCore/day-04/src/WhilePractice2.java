import java.util.Random;
import java.util.Scanner;

public class WhilePractice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int number;
        int value = rd.nextInt(101);
        boolean isQuit = false;
        while (!isQuit) {
            System.out.print("Nhập số bất kì: ");
            number = sc.nextInt();
            if (number < value) {
                System.out.println("Bạn nhập số nhỏ hơn rồi, cho nhập lại!");
            } else if (number > value) {
                System.out.println("Bạn nhập số lớn hơn rồi, cho nhập lại!");
            }   else {
                System.out.println("Chúc mừng bạn nhập đúng rồi!");
                isQuit = true;
            }
        }
    }
}
