# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MyHashMap {
    
    class  Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node [] storage;
    
    public MyHashMap() {
        this.storage = new Node[1000];
    }

    private int hashFunction(int key){
        return key%storage.length;
    }

    private Node find(Node node, int key){
        Node cur = node;
        Node prev = null;
        while(cur != null && cur.key != key){
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = hashFunction(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        }
        Node prev = find(storage[bucket], key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        } else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int bucket = hashFunction(key);
        if(storage[bucket] == null) return -1;
        Node prev = find(storage[bucket], key);
        if(prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket = hashFunction(key);
        if(storage[bucket] == null) return;
        Node prev = find(storage[bucket], key);
        if(prev.next == null) return;
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */