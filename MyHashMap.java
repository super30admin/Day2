
//Time complexity: O(n)
//Space Complexity: O(n)
class MyHashMap {
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    int buckets;
    Node[] storage;

    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }

    private int hashcode(int key){
        return key % buckets;
    }

    private Node findNode(Node dummy, int key){
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucket = hashcode(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1, -1);
        }
        Node prev = findNode(storage[bucket], key);
        if(prev.next != null){
            prev.next.value = value;
        } else {
            prev.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int bucket = hashcode(key);
        if(storage[bucket] == null){
            return -1;
        }
        Node prev = findNode(storage[bucket], key);
        if(prev.next != null){
            return prev.next.value;
        } else {
            return -1;
        }
    }

    public void remove(int key) {
        int bucket = hashcode(key);
        if(storage[bucket] == null){
            return;
        }
        Node prev = findNode(storage[bucket], key);
        if(prev.next != null){
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