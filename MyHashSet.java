class MyHashSet {
    
    class Node{
        int val;
        Node next;
        
        public Node(int val){
            this.val = val;
        }
    }

    private Node[] chainNodes;
    int len;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.len = 10007; // A prime number.
        this.chainNodes = new Node[len];
    }
    
    public void add(int key) {
        if(contains(key)){
            return;
        }
        int num = key%this.len;
        Node temp = chainNodes[num];
        if(temp == null){
            chainNodes[num] = new Node(key); 
        }else{
            while(temp.next !=null){
                temp = temp.next;
            }
            if(temp.next == null && temp.val != key){
                temp.next = new Node(key);
            }
        }
    }
    
    public void remove(int key) {
        int num = key%this.len;
        Node temp = chainNodes[num];
        if(temp!=null && temp.val == key){
            chainNodes[num] = temp.next;
            return;
        }
        Node prev = temp;
        if(temp != null){
            while(temp !=null && temp.val != key){
                prev = temp;
                temp = temp.next;
            }
            if(temp!=null && temp.val == key){
                prev.next = temp.next;
            } 
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int num = key%this.len;
        Node temp = chainNodes[num];
        if(temp != null){
            while(temp !=null && temp.val != key){
                temp = temp.next;
            }
            if(temp!=null && temp.val == key){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */