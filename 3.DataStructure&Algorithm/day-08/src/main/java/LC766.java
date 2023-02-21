// Yêu cầu đề bài:
// Cho 1 ma trận m x n, nếu đường chéo từ trên cùng bên trái xuống dưới cuùng bên phải
// đều là 1 số thì trả về đúng, ngược lại

// Ý tưởng thực hiện:
// Chạy 2 vòng for với điều kiện  a[i][j] != a[i+1][j+1] thì trả về false

// Thời gian chạy:
// 0((n-1)*(m-1)) = O(nm) = O(n^2)

public class LC766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length-1; i++) {   // n-1 bước tính toán
            for (int j = 0; j < matrix[0].length-1; j++) {  // n-1 bước tính toán
                if (matrix[i][j] != matrix[i+1][j+1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
