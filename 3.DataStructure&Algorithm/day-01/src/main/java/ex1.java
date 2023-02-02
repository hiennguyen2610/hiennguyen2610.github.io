import java.util.ArrayList;
import java.util.List;

public class ex1 {
    public static void main(String[] args) {
        int[] arr = new int[4];
        arr[0] = 5;
        arr[1] = 2;
        arr[2] = 6;

        // Chèn số 3 vào index = 1
//        arr[3] = arr[2];
//        arr[2] = arr[1];
//        arr[1] = 3;
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        for (int i = arr.length - 1; i > 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[1] = 3;
        for (int i : arr) {
            System.out.println(i);
        }
        arr[3] = 0;

        for (int i = 1; i < arr.length -1; i++) {
            arr[i] = arr[i+1];
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
