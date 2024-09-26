class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Node[] storage;
    private int hash(int key){
        return key%10000;
    }
    public MyHashMap() {
        this.storage = new Node[10000];
        
    }
    private Node find(Node node, int key){
        Node prev = null;
        Node curr = node;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int hash = hash(key);
        if(storage[hash] == null){
            storage[hash] = new Node(-1, -1);
        }
        Node prev = find(storage[hash], key);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        else
        {
            prev.next.val = value;
        }
        
    }
    
    public int get(int key) {
        int hash = hash(key);
        if(storage[hash] == null) return -1;
        Node prev = find(storage[hash], key);
        if(prev.next == null) return -1;
        return prev.next.val;
        
    }
    
    public void remove(int key) {
        int hash = hash(key);
       if(storage[hash] == null) return;
         Node prev = find(storage[hash], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
        
    }
}