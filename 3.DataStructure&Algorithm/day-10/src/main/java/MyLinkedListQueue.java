public class MyLinkedListQueue {
   static class Node{
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static int size;
    static Node head;
    static Node tail;

    public static int getSize() {
        // return size of Queue
        return size;
    }

    public static int getFirst() {
        // return the first element in Queue
        if (head == null) {
            return -1; // rỗng
        }
        return head.val;
    }

    public static int removeFirst() {
        // remove the first element and return value

        // have only element -> head == tail
        // remove head -> head = null
        // tail -> null
        int val = -1;
        if (head == tail) {  // chỉ có 1 phần tử
            val = head.val;
            head = head.next;
            tail = tail.next;
        } else {
            val = head.val;
            head = head.next;  // nhiều hơn 1 phần tử
        }
        size--;
        return  val;
    }

    public static void push(int val) {
        Node newNode = new Node(val);
        // add a new element into Queue
        //head == null, tail == null
        //head = tail = newNode
        if (head==null) {
            head= newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
        // tail.next = newNode
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val+"->");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        push(0);
        push(1);
        push(2);
        push(3);
        push(4);

        print(head);
        System.out.println("removeFirst: "+removeFirst());
        print(head);

    }
}
