import java.util.Arrays;

public class LeetCode217 {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,14,18,22};
        System.out.println(containsDuplicate(arr));
        System.out.println(Arrays.toString(arr));

    }
}
