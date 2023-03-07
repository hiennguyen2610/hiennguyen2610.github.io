// Phân tích đề bài:
// Cho 1 mảng số nguyên, yêu cầu tính tổng cuủa các phần tử chỉ xuất hiện 1 lần trong mảng

// Ý tưởng thực hiện:
// Dùng 2 vòng for để kiểm tra số lần xuất hiện của từng phần tử
// Tạo 1 biến count để đếm số lần xuất hiện của phần tử
// nếu count = 0 thì phần tử đó chỉ xuất hiện 1 lần, ta cộng nó vào biến sum

// Độ phức tạp thuật toán: O(n^2)

public class LeetCode1748 {
    public int sumOfUnique(int[] nums) {
        
        // Tạo biến sum để tính tổng
        int sum = 0;
        
        // Duyệt các phần tử trong mảng để tìm pt giống nhau
        for (int i = 0; i < nums.length; i++) {

            // tạo biến đếm số lần xuất hiện của phần tử
            int count = 0;

            for (int j = 0; j < nums.length; j++) {

                // Điều kiện kiểm tra
                if (i!=j && nums[i] == nums[j]) {
                    count++; // thì tăng biến đếm lên 1
                }
            }

            // nếu phần tử chỉ xuất hiện 1 lần thì cộng nó vào biến sum
            if (count == 0) {
                sum += nums[i];
            }
        }

        // Trả về kq là sum
        return sum;
    }
}
