// Time Complexity(put,remove, get) = O(N/K) N is number of item, k is the bucket size
//Space Complexity- O(M) * O(N) M is the size of array. N is the numbe of elements in the single array linked list

class MyHashMap {

    private class Node {
        int val, key;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private static final int BUCKET_SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[BUCKET_SIZE];
    }

    public int getKey(int key) {
        return key % BUCKET_SIZE;
    }

    public Node findPrev(int key) {
        int hash = getKey(key);
        if (buckets[hash] == null)
            return null;
        Node prev = buckets[hash];
        Node curr = prev.next;

        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;

        }
        return prev;
    }

    public void put(int key, int val) {
        Node prev = findPrev(key);
        if (prev == null) {
            int hash = getKey(key);
            buckets[hash] = new Node(-1, -1);
            prev = buckets[hash];
        }
        if (prev.next != null) {
            prev.next.val = val;
        } else {
            prev.next = new Node(key, val);
        }
    }

    public int get(int key) {
        Node prev = findPrev(key);
        if (prev == null || prev.next == null)
            return -1;
        return prev.next.val;
    }

    public void remove(int key) {
        Node prev = findPrev(key);
        if (prev == null || prev.next == null)
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