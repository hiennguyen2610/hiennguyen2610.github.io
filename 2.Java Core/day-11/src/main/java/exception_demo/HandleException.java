package exception_demo;

public class HandleException {
    public static void main(String[] args) {
        try {
            methodOne();
            methodTwo();
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Lỗi");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Finally");
        }
//        catch (NullPointerException e) {
//            System.out.println("Xử lý lỗi NullPointer");
//        }

        System.out.println("Code continue...");
    }

    public static void methodOne()   {
        int number = 9;
        int zero = 1;
        int result = number/zero;
        System.out.println(result);
    }

    public static void methodTwo() {
        String str = null;
        System.out.println(str.length());
    }
}
