/*
Time Complexity:  O(n/k) where n is the keys and k is bucket size, here k is 10000.

Space Complexity: O(n + k) where n is unique keys and k is the bucket size.

*/
class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {

            this.key = key;
            this.val = val;

        }
    }

    private Node[] nodes;
    private int bucket;

    public MyHashMap() {

        bucket = 10000;
        nodes = new Node[bucket];
    }

    private int hash(int key) {

        return key % bucket;
    }

    public Node find(Node head, int key) {

        Node prev = null;
        Node curr = head;

        while (curr != null && curr.key != key) {

            prev = curr;
            curr = curr.next;

        }
        return prev;
    }

    public void put(int key, int value) {

        int index = hash(key);
        if (nodes[index] == null) {

            nodes[index] = new Node(-1, -1);
        }
        Node prev = find(nodes[index], key);
        if (prev.next == null) {

            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }

    }

    public int get(int key) {

        int index = hash(key);
        if (nodes[index] == null) {

            return -1;
        }
        Node prev = find(nodes[index], key);
        if (prev.next == null) {
            return -1;
        }

        return prev.next.val;

    }

    public void remove(int key) {

        int index = hash(key);
        if (nodes[index] == null) {

            return;
        }
        Node prev = find(nodes[index], key);

        if (prev.next == null)
            return;
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */