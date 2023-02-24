import java.util.LinkedList;
import java.util.Queue;

public class LeetCode933 {
    Queue<Integer> queue;

    public LeetCode933() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && t - queue.peek() > 3000) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}
