class MyHashMap {

    int buckets;
    Node[] hashMap;

    public MyHashMap() {
        buckets = 1000;
        hashMap = new Node[1000];
    }

    private class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    public int getBucket(int key) {
        return Integer.hashCode(key)%buckets;
    }

    // To find a node with given key
    private Node find(Node dummy, int key) {
        Node prev = dummy;
        Node curr = prev.next;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public void put(int key, int value) {

        //get the bucket to put this item
        int bucket = getBucket(key);
        if(hashMap[bucket] == null) {
            hashMap[bucket] = new Node(-1, -1);
        }

        Node prev = find(hashMap[bucket], key);

        //if key is found
        if(prev.next != null) {
            prev.next.value = value;
        }

        else {
            prev.next = new Node(key, value);
        }
    }

    public int get(int key) {

        //get the bucket to put this item
        int bucket = getBucket(key);

        if(hashMap[bucket] == null) {
            return -1;
        }

        Node prev = find(hashMap[bucket], key);
        if(prev.next != null)
            return prev.next.value;

        return -1;
    }

    public void remove(int key) {
        //get the bucket to put this item
        int bucket = getBucket(key);

        if(hashMap[bucket] == null) {
            return;
        }

        Node prev = find(hashMap[bucket], key);
        if(prev.next != null)
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