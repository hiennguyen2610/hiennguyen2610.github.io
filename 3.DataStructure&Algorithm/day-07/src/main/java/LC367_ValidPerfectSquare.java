// Yêu cầu đề bài:
// Kiểm tra xem căn bậc 2 của 1 số nguyên có là 1 số nguyên hay ko

// Ý tưởng thực hiện:
// Chạy vòng for với i bắt đầu từ 0 và i*i <= num
// điều kiện đủ: i*i >= 0 và i*i = num

public class LC367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        for (int i = 0; i*i >= 0 && i*i <= num; i++) {
            if (i*i == num) {
                return true;
            }
        }
        return false;
    }
}
