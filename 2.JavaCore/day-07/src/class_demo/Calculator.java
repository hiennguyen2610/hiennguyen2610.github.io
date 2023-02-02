package class_demo;

public class Calculator {
    public int number1;
    public int number2;

    public void printInfo() {
        System.out.println("2 số là " + number1 + " và " + number2);
    }

    public double division() {
        if (number2 == 0) {
            System.out.println("Không thể thực hiện chia với mẫu số = 0");
           // return;   // Không có giá trị để return trả về nên sử dụng try catch
        }
        return (double) number1 / number2;

        // Sử dụng try-catch cho trường hợp lỗi
//        double result = 0;
//        try {
//            result = (double) (number1 / number2);
//
//        } catch (ArithmeticException e) {
//            System.out.println("Lỗi");
//        }
//        return result;
    }
}
