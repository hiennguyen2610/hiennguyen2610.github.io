public class HomeWork3 {
    public static void main(String[] args) {
        System.out.println(repeatString("a"));
        System.out.println(repeatString1("a"));
        System.out.println(repeatString2("a", 5));
        System.out.println(sumNumber());
        System.out.println(volGlobular(5.5));

        // Bài 6
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + " FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println(i + " Buzz");
            } else if (i % 3 == 0 ) {
                System.out.println(i + " Fizz");
            } else {
                System.out.println(i);
            }
        }
    }
        // Bài 1.
    public static String repeatString(String str) {
        String rs = "";
        for (int i = 0; i < 10; i++) {
            rs += str;
        }
        return rs;
    }
        // Bài 2.
    public static String repeatString1(String str) {
        String rs1 = "";
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                rs1 += str;
            } else {
                rs1 = rs1 + "-" + str;
            }
        }
        return rs1;
    }
        // Bài 3.
    public static String repeatString2(String str, int count) {
        String rs2 = "";
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                rs2 += str;
            } else {
                rs2 = rs2 + "-" + str;
            }
        }
        return rs2;
    }
        // Bài 4.
    public static int sumNumber() {
        int number = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0) {
                number += i;
            }
        }
        return number;
    }
        // Bài 5.
    public static double volGlobular(double r) {
        double vol;
        vol = (4/3) * Math.PI * r * r * r;
        return vol;
    }
}
