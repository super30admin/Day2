//TC = O(1) ; LL is 100 size max

class MyHashMap {
    // we are searching by using key value pairs, smallest DS is LL
    //we dont ArrayList bcz underhood it is static Array and resizes if its 80% full
    class Node{
        int key;
        int val;
        Node next; //by default in java its null
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private int hash(int key){
        return key%10000;
    }
    
    //data type Node for Array
    Node [] storage;
    
    public MyHashMap() {
        this.storage = new Node[10000];
    }   
    
    //search the node
    private Node find(Node node, int key){
        Node prev = null;
        Node curr = node;
        while(curr != null && curr.key != key){
            // inc the prev and curr;
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    

    
    public void put(int key, int value) {
        int idx = hash(key);
        
        if(storage[idx]  == null){
            //create a dummy at idx bcz, if we wanna remove first key, we can't
            storage[idx] = new Node(-1,-1);
        }
        Node prev = find(storage[idx], key);
        if(prev.next == null){
            prev.next = new Node(key, value); // dont exits, create a new node and key, value to it
        }
        else{
            prev.next.val = value; // if exists update the value
        }
    }
    
    public int get(int key) {
        int idx = hash(key);
        if(storage[idx] == null) return -1;        
        Node prev = find(storage[idx], key);
        if(prev.next == null) return -1;  
        return prev.next.val;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx] == null) return;
        
        Node prev = find(storage[idx], key);
        if(prev.next == null) return;
        
        prev.next = prev.next.next; // reomve the node
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
