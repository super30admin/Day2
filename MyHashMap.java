class MyHashMap {

    Node[] arr;
    int arrSize = 0;

    public MyHashMap() {
        arrSize = 10000;
        arr = new Node[arrSize];
    }

    private int hashValue(int key) {
        return key % arrSize;
    }

    private Node findPrev(int key, Node head) {

        Node curr = head;

        Node prev = curr;

        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hash = hashValue(key);

        if (arr[hash] == null) {
            arr[hash] = new Node(-key, -key);
        }

        Node newNode = new Node(key, value);

        Node prev = findPrev(key, arr[hash]);

        if (prev != null) {
            if (prev.next == null) {
                prev.next = newNode;
            } else {
                prev.next.val = value;
            }
        }
    }
    
    public int get(int key) {
        int hash = hashValue(key);
        if (arr[hash] == null) {
            return -1;
        }

        Node prev = findPrev(key, arr[hash]);

        if (prev != null) {
            if (prev.next == null) {
                return -1;
            } else {
                return prev.next.val;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = hashValue(key);
        if (arr[hash] == null) {
            return;
        }

        Node prev = findPrev(key, arr[hash]);

        if (prev != null) {
            if (prev.next == null) {
                return;
            } else {
                Node curr = prev.next;
                prev.next = prev.next.next;
                curr = null;
            }
        }
    }

    public class Node {
        int val;
        int key;
        Node next;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */