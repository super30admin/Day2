class MyHashMap {

    int buckets;
    Node[] storage;

    class Node{
        int key, value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[this.buckets];
    }

    int getBucket(int key){
        return key % this.buckets;
    }

    Node find(Node dummy, int key){
        Node prev = dummy;
        Node curr = dummy.next;

        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next!=null){
            prev.next.value = value;
        }else{
            prev.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return -1;
        }
        Node node = find(storage[bucket], key);
        if(node.next == null){
            return -1;
        }
        return node.next.value;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket] == null){
            return;
        }
        Node node = find(storage[bucket], key);
        if(node.next != null){
            node.next = node.next.next;
        }
    }
}
