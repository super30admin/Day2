class MyHashMap {

    
    class Node
    {
        int key;
        int val;
        Node next;
        
        public Node(int key, int val)
        {
            this.key = key;
            this.val =val;
        }
    }
    
    Node[] storage;
    private static final int bucketSize = 10000;
    
    public MyHashMap() {
        
        storage = new Node[bucketSize];
        
    }
    
    private int hash(int key)
    {
        return key % bucketSize;
    }
    
    private Node find(Node node, int key)
    {
        Node prev = null;
        Node curr = node;
        while(curr!= null && curr.key!= key){
                prev = curr;
                curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
         int hashvalue = hash(key);
        if(storage[hashvalue] == null)
        {
            storage[hashvalue] = new Node(-1,-1);
        }
        Node prev = find(storage[hashvalue], key);
        if(prev.next == null)
        {
            prev.next = new Node(key, value); // prev.next doesn't give null pointer exception
        }
        else {
           
            prev.next.val = value;
        }
                
    }
    
    public int get(int key) {
        int hashvalue = hash(key);
        if(storage[hashvalue] == null) return -1;
        Node prev = find(storage[hashvalue],key);
        if(prev.next != null){
            return prev.next.val;
        }
        return -1;        
        
    }
    
    public void remove(int key) {
        int hashvalue = hash(key);
        if(storage[hashvalue] == null) return;
         Node prev = find(storage[hashvalue],key);
         if(prev != null){
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
