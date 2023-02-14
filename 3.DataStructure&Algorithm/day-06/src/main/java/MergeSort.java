import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
//        int[] a1 = {1,3,5,7};
//        int[] a2 = {2,4,6,8};
//
//        int[] res = merge2Arrays(a1,a2);
//        System.out.println(Arrays.toString(res));
        int[] arr = {1,5,2,6,3,8,7,4};
        System.out.println("array: " + Arrays.toString(arr));

        int[] res = mergeSort(arr, 0, arr.length-1)
        System.out.println("res = " +);
    }

    private static int[] mergeSort(int[]arr, int left, int right) {
        // Mảng có duy nhất 1 phần tử -> chắc chắn sorted
        // lấy ra mảng có 1 phần tử

        if (left == right) {
            return new int[] {arr[left]};
        }
        int mid = left + (right-left)/2;
        int[] a1 = mergeSort(arr,left,mid);
        int[] a2 = mergeSort(arr, mid+1, right);
        int[] res = merge2Arrays(a1,a2);
        System.out.println("Done merge tu " + left + " den " + right);
        System.out.println(Arrays.toString(arr));
        return res;
    }

    private static int[] merge2Arrays(int[] a1,int[] a2) {
        // a1, a2 sorted
        int[] res = new int[a1.length + a2.length];
        int index = 0;  // current index for updating
        int i = 0;  // for a1
        int j = 0;  // for a2
        while (i < a1.length && j < a2.length) {
            // break khi i hoặc j chạy hết mảng
            if (a1[i] < a2[j]) {
                // phần tử đang xét tại a1 < phần tử đang xét tại a2
                res[index] = a1[i]; // thâm a[i] vào res -> a[i] xem như đã được remove
                i++;
            } else {
                res[index]  = a2[j];
                j++;
            }
            index++;
        }
        while (i<a1.length) {  // a1 còn, chắc chắn a2 hết
            // điền tất cả phần tử còn lại của a1 vào res
            res[index] = a1[i];
            index++;
            i++;
        }
        while (j < a2.length) {
            res[index] = a2[j];
            index++;
            j++;
        }
        // return res[] được sắp xếp, merge từ a1 và a2
        // 1,2,3,4,5,6,7,8
        return res;
    }
}
