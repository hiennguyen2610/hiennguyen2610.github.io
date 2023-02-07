import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr ={5,3,2,7,8,1,2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int keyNumber = arr[i];
            int j = i - 1; // Vị trí bắt đầu duyệt của mảng phía bên trái
            while (j >= 0 && arr[j] > keyNumber) {
                arr[j+1] = arr[j]; // Dịch sang bên phải để chèn
                j--;
            }
            // Tại j thì arr[j] < keyNumber
            arr[j+1] = keyNumber;
            System.out.print(i + " : ");
            System.out.println(Arrays.toString(arr));
        }
    }
}
