import java.util.LinkedList;
import java.util.List;

public class MyHashMap {
    // array of buckets
//    List<Node>

    private static final int SIZE = 10000;
    private List<Node>[] buckets;

    public MyHashMap() {
        buckets = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }

        String s;
    }

    public void put(int key, int value) {
        // biến key thành 1 index:
        int hashIndex = hashFunction(key);
        // lấy ra bucket để chứa key đó
        List<Node> bucket = buckets[hashIndex];

        // nếu bucket chưa từng có key này
        // check xem bucket có node key này chưa
        Node node = new Node(key, value);
        int indexOfKey = bucket.indexOf(node);
        if (indexOfKey == -1) {
            // bucket chưa có key này, chỉ việc add
            bucket.add(node);
        } else {
            bucket.get(indexOfKey).value = value;
        }
//        if (bucket.contains(node)) {
//            // bucket đã chứa key này rồi
//            // ghi đè giá trị value mới
//            int indexOfKey = bucket.indexOf(node);
//            bucket.get(indexOfKey).value = value;
//
//        } else {
//            // bucket chưa chứa key này, chỉ việc add
//            bucket.add(node);
//        }

        // nếu bucket đã có key này

    }

    public int get(int key) {
        // tìm hash index
        int hashIndex = hashFunction(key);
        List<Node> bucket = buckets[hashIndex];
        // nếu bucket chưa từng có key này
        // check xem bucket có node key này chưa
        Node node = new Node(key, -1);
        int indexOfKey = bucket.indexOf(node);
        if (indexOfKey == -1) {
            // bucket chưa có key này, return -1;
            return -1;
        } else {
            // bucket có key này, return value
            return bucket.get(indexOfKey).value;
        }
    }

    public void remove(int key) {
// tìm hash index
        int hashIndex = hashFunction(key);
        List<Node> bucket = buckets[hashIndex];
        Node node = new Node(key, -1);
        int indexOfKey  = bucket.indexOf(node);
        if (indexOfKey != -1) {
            bucket.remove(node);
        }
    }

    // hash
    private int hashFunction(int key) {
        // SIZE = 10000;
        // key = 5     -> hashValue = 5
        // key = 100   -> hashValue = 100
        // key = 10005 -> hashValue = 5    ->  collision
        // key = 10001 -> hashValue = 1
        // key = 1     -> hashValue = 1    ->  collision

        return key % SIZE;
    }

    static class Node {
        public int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return this.key == node.key;
        }
    }
}
