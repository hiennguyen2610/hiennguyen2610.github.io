import java.util.Random;

public class bai3 {
    public static void main(String[] args) {
        Random rd = new Random();
        int value = rd.nextInt();
        isPrimeNumber(value);

        // Kiểm tra số nguyên tố
        if(isPrimeNumber(value)){
            System.out.println(value+" là số nguyên tố");
        } else {
            System.out.println(value+" không là số nguyên tố");
        }
    }

        // Điều kiện số nguyên tố
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
