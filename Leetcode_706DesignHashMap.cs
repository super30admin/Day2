public class MyHashMap {
    
    public class Node{
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    Node[] storage;
    int buckets; 
     
    
    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets+1];
    }
    
    //calculate HashFunction
    public int getHash(int key)
    {
        return Math.Abs(key.GetHashCode()) % buckets;
    }
    
    //find prev node for a the other functionality 
    public Node findPrev(Node head, int key)
    {
        Node prev = null;
        Node curr = head;
        while(curr !=  null && curr.key != key) //make sure this is while loop not if!!
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void Put(int key, int value) {
        int hash = getHash(key);
        
        //if not even initialized??
        if(storage[hash] == null)
        {
            storage[hash] = new Node(-1,-1);
            storage[hash].next = new Node(key, value);
        }
        //check if node exist, so look for the prev node
        else
        {
            Node prev = findPrev(storage[hash], key);
        
            if(prev.next == null) //add a new node, it doesnt exist
            {
                prev.next = new Node(key, value);
            }else
            {
                prev.next.val = value;
            }
        }
    }
    
    public int Get(int key) {
        //calculate Hash
        int hash = getHash(key);
        
        //check if node initialized or null
        if(storage[hash] == null) 
            return -1;
        
        Node prev = findPrev(storage[hash], key);
        
        if(prev.next == null) //we never found any key
            return -1;
        else
            return prev.next.val;
    }
    
    public void Remove(int key) {
        
        //get hash
        int hash = getHash(key);
        
        //check if the node ever exist/intialized
        if(storage[hash] == null) 
            return;
        
        Node prev = findPrev(storage[hash], key);
        
        //check if the prev next is null or we actually found a node
        if(prev.next == null)
            return;
        else
            prev.next = prev.next.next;
            
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.Put(key,value);
 * int param_2 = obj.Get(key);
 * obj.Remove(key);
 */