public class Main {
    public static void main(String[] args) {
        MyObject myObject1 = new MyObject(1);
        MyObject myObject2 = new MyObject(1);

//        System.out.println(myObject1.equals(myObject2));
        // convert String -> number
        // convert 1 số bất kì
        // tự xây dựng công thức
        String s = "hello world";
        System.out.println(myHashString(s));
    }

    private static int myHashString(String s) {
        return s.length();
    }

    static class MyObject {
        int val;

        MyObject(int val) {
            this.val = val;
        }
    }
}
