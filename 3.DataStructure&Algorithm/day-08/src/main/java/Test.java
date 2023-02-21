public class Test {

    // Cach 1
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] T = new int[n];
        int iT = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0 ) {
                T[iT++] = nums[i];
            }
        }
    }

    // Cach 2
    public static void moveZeroes2(int[] a) {
        int n = a.length;
        int curIndex = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0 ) {
                a[curIndex++] = a[i];
            }
        }
    }
}
