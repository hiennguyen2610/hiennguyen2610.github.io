public class LeetCode707 {
    int size;
    Node head;

    public LeetCode707() {

    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.val;
            }
            count++;
            current = current.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (index < size) {
            Node current = head;
            int count = 0;
            while (current != null) {
                if (count == index - 1) {
                    Node newNode = new Node(val);
                    newNode.next = current.next;
                    current.next = newNode;
                }
                count++;
                current = current.next;
            }
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
        } else if (index < size) {
            Node current = head;
            int count = 0;
            while (current != null) {
                if (count == index - 1) {
                    current.next = current.next.next;
                }
            }
            size--;
        }
    }

    static class Node {
        public int val;
        public Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
