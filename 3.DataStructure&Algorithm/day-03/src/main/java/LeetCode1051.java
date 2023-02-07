import java.util.Arrays;

public class LeetCode1051 {
    public static int heightChecker(int[] heights) {
        int result = 0;
        int[] arr = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            arr[i] = heights[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != arr[i]) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,1,1,3,5,4};
        System.out.println(heightChecker(array));
    }
}
