// Phân tích đề bài: chuyển các số 0 trong 1 mảng về cuối mảng, các số còn lại giữ nguyên

// Ý tưởng thực hiện:
// Sử dụng vòng lặp với điều kiện n != 0 thì thêm vào vị trí đầu tiên của mảng và tiếp tục như thế
// dùng vòng lặp tiếp theo duyệt các phần tử còn lại và gán = 0

// Thời gian chạy: trong vòng for 1 và 2 đều có i chạy từ 0 đến <n nên wostcase = n
// Fn = n + n = 2n
// O(Fn) = O(2n) = O(n)
public class LC283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int curIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[curIndex++] = nums[i];
            }
        }
        for (int i = curIndex; i < n; i++) {
            nums[i] = 0;
        }
    }
}
