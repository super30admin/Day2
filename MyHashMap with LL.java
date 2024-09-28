class MyHashMap {

    class Node{
        int key,value;
        Node next;
        Node(int key,int value)
        {
            this.key=key;
            this.value=value;
            next=null;
        }
    }
    
    Node[] primary;
    int buckets;
    Node prev;
    
    public MyHashMap() {
        
        prev=null;
        buckets=10000;
        primary=new Node[buckets];
        
    }
    
    int hash1(int key)
    {
        return key%buckets;
    }
    
    private Node find( Node temp,int key)
    {
        prev=temp;
        while(prev.next!=null && prev.next.key!=key)
        {
            prev=prev.next;
        }
        
        return prev;
    }
    
    public void put(int key, int value) {
        
        int bucket=hash1(key);
        if(primary[bucket]==null)
        {
            primary[bucket]=new Node(-1,-1);
        }
        
        prev=find(primary[bucket],key);
        if(prev.next==null)
            prev.next=new Node(key,value);
        else
            prev.next.value=value;
        
        
    }
    
    public int get(int key) {
        
        int bucket=hash1(key);
        if(primary[bucket]==null)
            return -1;
        
        prev=find(primary[bucket],key);
        return (prev.next==null)?-1:prev.next.value;
        
        
    }
    
    public void remove(int key) {
        
        int bucket=hash1(key);
        if(primary[bucket]==null)
            return;
        
        prev=find(primary[bucket],key);
        if(prev.next==null)
            return;
        prev.next=prev.next.next;
        

        
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */