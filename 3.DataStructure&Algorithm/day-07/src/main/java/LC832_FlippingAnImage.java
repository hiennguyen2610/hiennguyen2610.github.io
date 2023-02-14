// Phân tích đề bài:
// Cho 1 mảng 2 chiều với các phần tử con gồm 0 và 1
// Thực hiện đảo ngược vị trí các index trong mảng con
// sau đó đảo ngược giá trị các index đó từ 0 thành 1 và ngược lại

// Ý tưởng thực hiện:
// Sử dụng


public class LC832_FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {

        // Lấy số hàng của ma trận
        int rowLength = image.length;

        // Lấy số cột của ma trận
        int colLength = image[0].length;

        // Duyệt qua từng hàng của mảng
        for (int i = 0; i < rowLength; i++) {
            // Duyệt qua nửa số cột của mảng
            for (int j = 0; j < (colLength + 1) / 2; j++) {
                int temp = image[i][j]; // Lưu giá trị tạm thời của phần tử hiện tại
                // Đảo ngược giá trị của phần tử hiện tại
                image[i][j] = 1 - image[i][colLength - 1 - j];
                // Đảo ngược giá trị của phần tử đối xứng sử
                image[i][colLength - 1 - j] = 1 - temp;
            }
        }

        return image; // Trả về kq
    }
}
