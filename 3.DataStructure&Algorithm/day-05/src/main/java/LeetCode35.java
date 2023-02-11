public class LeetCode35 {
    // Yêu cầu đề bài: tìm vị trí cần chèn 1 số vào dãy đã sắp xếp
    // nếu số đã có trong dãy thì trả về vị trí của nó
    // Sử dụng phương pháp tìm kiếm nhị phân để xác định vị trí cần chèn
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right) {
            int mid = (left+right)/2;

            // Nếu target bằng giá trị tại vị trí mid thì trả về mid
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
