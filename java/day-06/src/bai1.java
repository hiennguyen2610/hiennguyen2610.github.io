public class bai1 {
    public static void main(String[] args) {
        printSquare(4);
        System.out.println();
        printTriangle(4);
    }

    // In hình chữ nhật đặc
    public static void printSquare(int side) {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // In tam giac
    public static void printTriangle(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
