class MyHashMap {
    // this implementtation is using the chaining of array and to avoid clooision we
    // are using linked list, we also implement this using an secodanry array also
    // as we did in hashset implementation
    Node[] storage;
    int buckets;

    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }

    // this we need because we are going to use the link list as secondary storage:
    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // hashing function:
    private int gethash(int key) {
        return key % buckets;
    }

    // method to find the node, which can be used for get, put, remove:
    private Node getNode(Node head, int key) {
        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int hash = gethash(key);
        if (storage[hash] == null) {
            storage[hash] = new Node(-1, -1);//this is to handle the case when we have to remove the first node of ll, in that we have to handle this case seprately by keeping the check whether we are dealing with first node of node so by doing we do not have to worry about which node we are dealing with, in this case we are setting prev->(-1,-1) and current = prev.next
        }
        Node prev = getNode(storage[hash], key);
        if (prev.next != null) {// condition of duplciate key, in this udpate the value of alreay exisitin key
            prev.next.value = value;
            return;
        }
        prev.next = new Node(key, value);// this is when we are trying to insert a new key
    }

    public int get(int key) {
        int hash = gethash(key);
        if (storage[hash] == null) {
            return -1;
        }
        Node prev = getNode(storage[hash], key);
        if (prev.next != null) {
            return prev.next.value;
        }
        return -1;

    }

    public void remove(int key) {
        int hash = gethash(key);
        if (storage[hash] == null) {
            return;
        }
        Node prev = getNode(storage[hash], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
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

 //time complexity: O(N) because of find method
 //space complexity==> number of elements currently present in LL worst case o(n);