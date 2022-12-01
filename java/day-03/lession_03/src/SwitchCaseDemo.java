import java.util.Scanner;

public class SwitchCaseDemo {
    public static void main(String[] args) {
        Scanner inputDay = new Scanner(System.in);
        int day;
        System.out.println("Nhập số từ 0 đến 6:");
        day = inputDay.nextInt();
        switch (day) {
            case 0: {
                System.out.println("Chủ nhật");
                break;
            }
            case 1: {
                System.out.println("Thứ 2");
                break;
            }
            case 2: {
                System.out.println("Thứ 3");
                break;
            }
            case 3: {
                System.out.println("Thứ 4");
                break;
            }
            case 4: {
                System.out.println("Thứ 5");
                break;
            }
            case 5: {
                System.out.println("Thứ 6");
                break;
            }
            case 6: {
                System.out.println("Thứ 7");
                break;
            }
        }
    }
}
