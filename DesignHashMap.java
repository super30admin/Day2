import java.util.Arrays;

public class DesignHashMap {

    //time complexity: O(1) generally, better performance when there are no collisions or when the array is big
    //space complexity: O(n)
    class Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    //first attempt
    private Node[] map;
    int buckets;
    public DesignHashMap() {
        buckets = 1000001;
        map = new Node[buckets];
    }

    private Node find(Node head, int key) {
        Node prev = head;
        Node curr = head.next;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    private int getBucket(int key) {
        return key % buckets;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        if (map[bucket] == null) {
            map[bucket] = new Node(-1, -1);
        }
        Node prev = find(map[bucket], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int bucket = getBucket(key);
        if (map[bucket] == null) {
            return -1;
        }
        Node prev = find(map[bucket], key);
        return prev.next == null ? -1 : prev.next.value;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if (map[bucket] == null) {
            return;
        }
        Node prev = find(map[bucket], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }
}
