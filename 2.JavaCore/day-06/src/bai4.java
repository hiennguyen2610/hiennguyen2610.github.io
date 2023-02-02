public class bai4 {
    public static void main(String[] args) {
        int number = 0;
        int n = 2;

        // Liệt kê 10 số nguyên tố đầu tiên
        while (number < 10) {
            if (isPrimeNumber(n)) {
                System.out.print(n + " ");
                number++;
            }
            n++;
        }

        // Liệt kê các số nguyên tố nhỏ hơn 10
        for (n =2 ; n <= 10; n++) {
            if (isPrimeNumber(n)) {
                System.out.println(n + " ");
            }
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
