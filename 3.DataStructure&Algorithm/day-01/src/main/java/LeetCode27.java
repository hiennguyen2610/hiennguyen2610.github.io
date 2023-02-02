import java.util.Arrays;

public class LeetCode27 {
    public static int[] removeElement(int[] nums, int val) {
        int n = nums.length;
        int index = 0;
        int[] arrs = new int[nums.length];
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                arrs[index] = nums[i];
                index++;
            }
        }
        return arrs;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,3,5,1,7,3,5,3,6};
        System.out.println(Arrays.toString(removeElement(arr, 3)));
    }
}
