public class Test1 {
    public static void printArray(int[][] array, int i, int j) {
        // Nếu i bằng độ dài của mảng, dừng hàm
        if (i == array.length) {
            return;
        }

        // Nếu j bằng độ dài của mảng tại chiều thứ nhất, in xuống dòng và gọi lại hàm với i + 1, j = 0
        if (j == array[0].length) {
            System.out.println();
            printArray(array, i + 1, 0);
            return;
        }

        // In ra giá trị tại vị trí i, j
        System.out.print(array[i][j] + " ");
        // Gọi lại hàm với i, j + 1
        printArray(array, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3},
            {4,5,6}
        };

        printArray(arr,0,0);

    }
}
