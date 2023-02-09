public class LeetCode509 {
    public static int fib(int n) {
        // Điều kiện dừng
        if (n <= 1) { return n; }
        // Công thức quy nạp
        return fib(n-1) + fib(n-2);
    }
}
