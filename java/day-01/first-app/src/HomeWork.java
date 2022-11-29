public class HomeWork {
    public static void main(String[] args) {

        hello();
        hello1("TechMaster");
        hello2("TechMaster");
        System.out.println(sum(1,2));
        System.out.println(square(20));
        System.out.println(year(1998));
        System.out.println(bmi(62, 1.65));
    }

//    Bài 1
    public static void hello() {
        System.out.println("Xin chào các bạn");
    }

//    Bài 2
    public static void hello1(String techmaster) {
        System.out.println("Xin chào" + " " + techmaster);
    }

//    Bài 3
    public static void hello2(String techmaster) {
        System.out.println("Xin chào" + " " + "'TechMaster'");
    }

//    Bài 4
    public static int sum(int a, int b) {
        return a + b;
    }

//    Bài 5
    public static int square(int c) {
        return c*c;
    }

//    Bài 6
    public static double year(double d) {
        return Math.ceil( d/100);
    }

//    Bài 7
    public static double bmi(double w, double h ) {
        return w/(h*h);
    }
}
