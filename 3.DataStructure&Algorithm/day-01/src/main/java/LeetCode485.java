public class LeetCode485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count > a) {
                    a = count;
                }
            } else {
                count = 0;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,1,1,0,1,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
