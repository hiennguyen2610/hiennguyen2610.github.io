// Yêu cầu đề bài:
// Tính số lượng các cặp số có chỉ số bằng nhau trong 1 mảng
// Ví dụ: cho mảng [0,1,2,1,1,3,0]
// Tại index[0] = index[6] thì số lượng được tính là 1

// Ý tưởng thực hiện:
// Sử dụng 1 biến đếm count và 1 biến bằng chiều dài mảng
// Sau đó duyệt các cặp phần tử trong mảng với 2 for lồng nhau
// Trùng nhau thì biến đêm tăng lên 1
// Cuối cùng thì trả vẻ kq

public class LC1512_NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        // Khởi tạo biến đếm
        int count = 0;
        // Tạo biến lấy độ dài mảng
        int n = nums.length;

        // Duyệt qua từng cặp phần tử trong mảng
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) { // Nếu tìm được cặp phần tử bằng nhau thì tăng biến đêm lên 1
                    count++; // Tăng biến đếm lên 1
                }
            }
        }
        // Trả về kết quả
        return count;
    }
}
