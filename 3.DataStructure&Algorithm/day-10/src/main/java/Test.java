import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1); //~push
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.offer(6);

        queue.peek(); //~getFirst

        System.out.println(queue.peek());

        System.out.println(queue.poll());

        System.out.println(queue.peek());
    }
}
