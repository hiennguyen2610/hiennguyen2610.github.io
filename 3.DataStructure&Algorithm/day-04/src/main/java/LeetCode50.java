public class LeetCode50 {
    public static void main(String[] args) {

    }

    public static double myPow(double x, double n) {
        if (x == 0 || x == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -(n+1);
            return x*myPow(x,n);
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        return x * myPow(x * x, n / 2);
    }
}
