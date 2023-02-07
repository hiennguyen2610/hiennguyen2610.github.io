import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr ={5,3,2,7,8,1,2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap i va j
                    swap(arr,j, j+ 1);
                    isSwapped = true;
                }
            }
            System.out.print(i + " : ");
            System.out.println(Arrays.toString(arr));
            if (!isSwapped) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
