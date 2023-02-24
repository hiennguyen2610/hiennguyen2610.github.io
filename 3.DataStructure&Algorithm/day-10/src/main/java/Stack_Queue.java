public class Stack_Queue {
    private static final int SIZE = 100;
    static int[] arr;
    static int head;
    static int tail;

//    public Stack_Queue() {
//        arr = new int[SIZE];
//    }

    public static int getSize() {
        // return size of Queue
        return tail - head;
    }

    public static int getFirst() {
        // return the first element in Queue
        return arr[head];
    }

    public static int removeFirst() {
        // remove the first element and return
        int val = arr[head]; // save value
        head++;  // value
        return val;
    }

    public static void push(int val) {
        // add a new element into Queue
        if (head == tail) {
            System.out.println("Rỗng");
        }
        arr[tail++] = val;
    }

    public static void print() {
        for (int i = head; i < tail; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        arr = new int[SIZE];
        push(0);
        push(1);
        push(2);
        push(3);
        push(4);
        print();
        System.out.println("remove first = " + removeFirst());
        print();
        System.out.println("remove first = " + removeFirst());
        print();

        System.out.println("size = " + getSize());
    }
}
