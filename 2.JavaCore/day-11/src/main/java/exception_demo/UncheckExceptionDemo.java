package exception_demo;

public class UncheckExceptionDemo {
    public static void main(String[] args) {
        // Lỗi chia 1 số cho 0
//        int number = 9;
//        int zero = 0;
//        int result = number/zero;  //ArithmeticException

        // Lỗi thao tác với chuỗi rỗng
//        String str = null;
//        System.out.println(str.length()); //NullPointerException

        // Lỗi khi ép kiểu
//        String str = "Chuỗi";
//        int number = Integer.parseInt(str); //NumberFormatException

        // Lỗi thêm phần tử sai index trong mảng
//        int []arr = new int[5];
//        arr[10] = 7; //ArrayIndexOutOfBoundsException

        // Lỗi kích thước mảng là số âm
        int[] arr = new int[-5]; //NegativeArraySizeException



    }
}
