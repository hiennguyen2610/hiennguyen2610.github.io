import java.util.Arrays;

public class Array1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr1()));
        System.out.println(repeatString("a"));
        System.out.println(repeatString2("a"));
        System.out.println(checkElementExits(9));
    }

        // Bài 1
    public static int[] arr1() {
        int[] arr1 = {4, 2, 5, 6, 2, 7};
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] % 2 == 0) {
                arr1[i] = 0;
            } else {
                arr1[i] = 1;
            }
        } return arr1;
    }

        // Bài 2
    public static String repeatString(String b) {

        String arr2[] = new String[10];
        for (int i = 0; i < 10; i++) {
         arr2[i] = b;
        } return String.join("-", arr2);
    }

        // Bài 3
    public static String repeatString2(String c) {
        String arr2[] = new String[10];
        for (int i = 0; i < 10; i++) {
            arr2[i] = c;
        } return String.join("", arr2);
    }

        // Bài 4
    public static Boolean checkElementExits(int d) {
        int[] arr4 = {1,2,3,4,5};
        boolean result = false;
        for (int i = 0; i < arr4.length; i++) {
            if (arr4[i] == d) {
                result = true;
            } else {
                result = false;
            }
        } return result;
    }

        // Bài 5

}
