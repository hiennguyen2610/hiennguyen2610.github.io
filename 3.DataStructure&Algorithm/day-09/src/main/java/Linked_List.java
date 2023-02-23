// Array:
// Mảng là 1 cấu trúc có kích thước cố định
// Tốc độ truy xuất ngẫu nhiên nhanh O(1)
// Chèn vào đầu mảng O(n)
// Thực chất quá trình insert là dịch chuyển, thay đổi vị trí các phần tử
// Các ô nhớ liên tiếp nhau

// Linked List:
// Danh sách các phần tử có thể linh động
// Tốc độ tìm kiếm & truy xuất O(n)
// Tốc độ chèn vào đầu: O(1)
// Các ô nhớ không liên kết với nhau
// Tốn bộ nhớ hơn array do cần phải lưu thêm địa chỉ

public class Linked_List {
    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

//        printList(n0);

        // how to find the element with index = 4? (expect = n4; value = 4)
//        System.out.println(elementAt(n0,4).val);


//        Node newList = insertAtHead(n0,9);
//        printList(newList);

//        insertAtTail(n0,10);
//        printList(n0);

        printList(deleteAt(n0,2));
    }


    private static Node insertAtHead(Node head, int val) {
        // create new node
        // link newNode to head
        // assign head to new node
        Node newNode = new Node(val);
        if (head != null) {
            newNode.next = head;
        }
        return newNode;
    }

    private static Node insertAtTail(Node head, int val) {
        // check case list is empty
        Node newNode = new Node(val);
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        return newNode;
}

    private static void insert(Node head, int index, int valOfNewNode) {
        // find the node previous of indexNode
        // link the previous node to newNode
        // link newNode to nextNode of previous node
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            if (count == index) {
                Node newNode = new Node(valOfNewNode);
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
    }

    private static Node elementAt(Node head, int index) {
        Node current = head;  // n0
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current;
            }
            current = current.next;
            count++;
        }
        return null;
        //  Count   Node
        //  0       n0
        //  1       n1
        //  2       n2
        //  3       n3
        //  index   n(index)
    }

    private static Node deleteAt(Node head, int index) {
        if (index == 0) {
            head = head.next;
        }
        // find element at index - 1
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index - 1) {
                // link previous element to next of index element
                current.next = current.next.next;
                break;
            }
            count++;
            current = current.next;
        }
        return current;
    }

    private static Node printList(Node head) {
        Node current = head;  // current point to the head of List
        while (current != null) {
            // process current node
            System.out.print(current.val + "->");

            // move to next node
            current = current.next;
        }
        return head;
    }

static class Node {
    public int val;
    public Node next;

    Node(int val) {
        this.val = val;
    }
}
}
