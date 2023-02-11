public class LeetCode69 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left +(right - left)/2;
            if (x/mid == mid ) {
                return mid; // mid^2 = x
            }
            if (x/mid > mid ) {
                left = mid+1; // mid vẫn còn chưa đủ lớn, cần check ở range lớn hơn
            } else {
                right = mid -1 ; // mid đã lớn quá, cần check range nhỏ hơn
            }
        }
        return right;
    }
}
