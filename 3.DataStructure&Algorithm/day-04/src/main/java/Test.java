public class Test {
    public static void main(String[] args) {
//        print(0);
        doSomething();
    }



    private static void doSomething() {
        int mySum = sum(1,2);
        System.out.println(mySum);
    }

    private static int sum(int a, int b) {
        return a+b;
    }

    private static void print(int n) {
        System.out.println(n + " ");

    }
}
