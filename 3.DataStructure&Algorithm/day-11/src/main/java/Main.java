public class Main {
    public static void main(String[] args) {
        MyObject myObject1 = new MyObject(1);
        MyObject myObject2 = new MyObject(1);

        System.out.println(myObject1.equals(myObject2));
    }

    static class MyObject {
        int val;

        MyObject(int val) {
            this.val = val;
        }
    }
}
