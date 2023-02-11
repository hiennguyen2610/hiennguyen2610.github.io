/**
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is higher than the picked number
 * 1 if num is lower than the picked number
 * otherwise return 0
 * int guess(int num);
 */
public class LeetCode374 {
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (guess(mid) == 0) {
                return mid;  // Trả về mid khi số đoán bằng số đã cho
            } else if (guess(mid) == -1) {
                 end = mid - 1; // Trả về khi số đoán nhỏ hơn số đã cho
            } else {
                start = mid + 1;  // Trả về khi số đoán lớn hơn số đã cho
            }
        }
        return start;   // trả về khi start = end (kết thúc vòng while)
    }

    // Tạo hàm đoán số
    private static int guess(int mid) {
        int number = 5;
        if (mid > number) {
            return  -1;
        } else if (mid < number) {
            return 1;
        }
        return 0;
    }
}
