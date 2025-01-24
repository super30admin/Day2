public class MyHashMap {
    public class Node {
        public int Key;
        public int Val;
        public Node Next;

        public Node(int key, int val) {
            this.Key = key;
            this.Val = val;
        }
    }

    private Node[] storage;

    public MyHashMap() {
        this.storage = new Node[10000];
    }

    private int HashIdx(int key) {
        return key % 10000;
    }

    private Node Search(Node head, int key) {
        Node prev = head;
        Node curr = head.Next;
        while (curr != null && curr.Key != key) {
            prev = curr;
            curr = curr.Next;
        }
        return prev;
    }

    public void Put(int key, int value) {
        int idx = HashIdx(key);
        if (storage[idx] == null) {
            storage[idx] = new Node(-1, -1); // Dummy head node
        }
        Node prev = Search(storage[idx], key);
        if (prev.Next != null) {
            prev.Next.Val = value; // Update existing key's value
        } else {
            prev.Next = new Node(key, value); // Insert new key-value pair
        }
    }

    public int Get(int key) {
        int idx = HashIdx(key);
        if (storage[idx] == null) return -1; // Key not found
        Node prev = Search(storage[idx], key);
        if (prev.Next == null) return -1; // Key not found
        return prev.Next.Val; // Return the value
    }

    public void Remove(int key) {
        int idx = HashIdx(key);
        if (storage[idx] == null) return; // Key not found
        Node prev = Search(storage[idx], key);
        if (prev.Next == null) return; // Key not found
        prev.Next = prev.Next.Next; // Remove the key-value pair
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.Put(key, value);
 * int param_2 = obj.Get(key);
 * obj.Remove(key);
 */