public class LeetCode136 {
    public static int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    n++;
                }
            }
            if (n == 1) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,4};
        System.out.println(singleNumber(arr));
    }
}
