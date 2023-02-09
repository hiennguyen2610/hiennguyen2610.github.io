import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr ={5,3,2,7,8,1,2};
//        selectionSort(arr);
//        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        String[] words={
            "Tai",
            "Anh",
            "Kien",
            "Dung"
        };
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));

        Student[] students = {
                new Student(32,"Tai"),
                new Student(27,"Anh"),
                new Student(30,"Kien"),
        };
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+ 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
            System.out.print(i + " : ");
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
