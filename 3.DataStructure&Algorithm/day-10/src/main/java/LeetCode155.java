import java.util.Stack;

public class LeetCode155 {
    Stack<Node> stack;

    public LeetCode155() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.empty()) {
            Node node = new Node(val, val);
            stack.push(node);
        } else {
            Node peek = stack.peek();
            int min = Math.min(peek.min, val); // tìm thằng nhỏ nhất
            Node node = new Node(val, min);
            stack.push(node);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    static class Node {
        int val;
        int min;  // min hiện tại của stack

        Node(int val,int min)
        {
            this.val = val;
            this.min = min;
        }
    }
}
