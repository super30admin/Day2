// Time Complexity : O(1+M/N) where 1- constant time to access bucket index, M- no. of elments stored at that index, N- total number of buckets.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

class MyHashMap {
    class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] nodes; // primary array
    int buckets;

    private int getindex(int key) {
        return key % buckets; // to get bucket index
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

    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }

    public void put(int key, int value) {
        int index = getindex(key);
        if (nodes[index] == null) {
            nodes[index] = new Node(-1, -1); // create a dummy node at the index, if no LL is present
        }
        Node prev = find(nodes[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value); // if key isnt found, create a new node in the LL.
        } else {
            prev.next.value = value; // if key is found, update its value.
        }

    }

    public int get(int key) {
        int index = getindex(key);
        if (nodes[index] == null) {
            return -1; // no LL present itself.
        } else {
            Node prev = find(nodes[index], key);
            if (prev.next == null) { // key isnt present.
                return -1;
            }
            return prev.next.value; // key is present, return its value.
        }
    }

    public void remove(int key) {
        int index = getindex(key);
        if (nodes[index] == null) {
            return; // no LL present itself.
        } else {
            Node prev = find(nodes[index], key);
            if (prev.next == null) {
                return; // key isnt present.
            } else {
                prev.next = prev.next.next; // key is present, remove the respective node.
            }
        }
    }

    public static void main(String args[]) {
        MyHashMap obj = new MyHashMap();
        obj.put(1003,20);
        obj.put(1006,40);
        int param_2 = obj.get(1003);
        int param_3 = obj.get(1004);
        obj.remove(1006);

}
