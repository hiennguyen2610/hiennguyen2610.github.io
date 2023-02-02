import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi bất kì: ");
        String str = sc.nextLine();
        String[] arr = str.split("\\s");
        int length = arr.length;
        System.out.println("Số từ của chuỗi trên là: " + length);
        char[] arr1 = str.toCharArray();
        int sokitu = 0;
        char kitu = 'o';
        for (int i = 0; i < arr1.length; i++) {
            if (str.charAt(i) == kitu) {
                sokitu ++;
                System.out.println("Kí tự 'o' ở vị trí index là: " + i);
            }
        }
        System.out.println("Số lượng kí tự 'o' trong chuỗi là: " + sokitu);
    }
}
