// Phân tích đề bài:
// So sánh xem 2 cây nhị phân có giống nhau không

// Ý tưởng thực hiện:
// Kiểm tra các điều kiện so sánh 2 cây và sử dụng đệ quy để kiểm tra các nút con tiếp theo

// Độ phức tạp thuật toán: O(n)

public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Kiểm tra điều kiện:
        // Nếu cả 2 cây đều rỗng thì trả về true
        if (p == null && q == null) {
            return true;
        }

        // Nếu 1 trong 2 cây rỗng hoặc giá trị của nút hiện tại khác nhau -> false
        if (p == null || q == null || (p.val != q.val)) {
            return false;
        }

        // Sử dụng đệ quy để tiếp tục so sánh các nút con bên trái và phải
        // nếu tìm được nút khác nhau -> false -> dừng đệ quy
        // nếu giống nhau -> chạy đến cuối -> true
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
