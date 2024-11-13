//we use hash function, it gives us hash code which uniquely match to memory register to get value
// collision handling techniques in hashing- linear probing, quadratic probing, double hashing,linear chaining

class MyHashMap {
    int buckets;
    Node[] storage;

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }


    public MyHashMap() {
        this.buckets = 10000;//we are diving 10^6 into 10000 as initial node array, then 100 linked list node from 
        //each node of storage array
        this.storage = new Node[buckets];
        
    }

    private int getHash(int key){
        return key % buckets;
    }

    private Node getPrev(Node head, int key){
        Node prev = null;
        Node curr = head;

        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }
    
    public void put(int key, int value) {
        int hash = getHash(key);

        if(storage[hash] == null){
            storage[hash] = new Node(-1, -1);
        }

        Node prev = getPrev(storage[hash], key);

        if(prev.next == null){
            prev.next = new Node(key, value);//new node
        }
        else{
            prev.next.value = value;//existing node
        }
    }
    
    public int get(int key) {
        int hash = getHash(key);

        if(storage[hash] == null){
            return -1;
        }
        Node prev = getPrev(storage[hash], key);

        if(prev.next == null){
            return -1;
        }
        else{
            return prev.next.value;
        }
        
    }
    
    public void remove(int key) {
        int hash = getHash(key);
        if(storage[hash] == null){
            return;
        }
        Node prev = getPrev(storage[hash], key);
        if(prev.next == null){// node does not exist
            return;
        }

        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
        
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */