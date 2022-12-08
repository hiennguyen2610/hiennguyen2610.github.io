import java.util.Scanner;
import java.util.regex.Pattern;
public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập email: ");
        String email = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = sc.nextLine();
        String EMAIL_PATTERN =
                "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";

        char[] arrPhone = phoneNumber.toCharArray();
        if (arrPhone.length <= 11 && arrPhone.length >= 9) {
            System.out.println(phoneNumber + ": true");
        } else {
            System.out.println(phoneNumber + ": false");
        }
        System.out.println(email + ": " + Pattern.matches(EMAIL_PATTERN, email));

    }
}
