// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class MyHashMap {
    
    class Node {
        int key;
        int value;
        Node next;
        
        Node(int key,int val)
        {
            this.key=key;
            this.value=val;
        }
    }
    
    Node[] storage;
    int bucket=10000;
        

    //1000000
    public MyHashMap() {
        storage = new Node[bucket]; 
    }
    
    private int hash(int key)
    {
        return key%bucket;
    }
    
    private Node find(Node node, int key)
    {
       Node prev=null;
       Node current = node;
        
       while(current!=null && current.key!=key)
       {
           prev=current;
           current=current.next;
       }
        
        return prev;
        
    }
    
    public void put(int key, int value) {
       int index = hash(key);
       if(storage[index]==null)
       {
           storage[index] = new Node(-1,-1);
           //storage[index].next=  new Node(key,value);
       }
      
           Node prev = find(storage[index],key);
           if(prev.next!=null)
           prev.next.value=value;
           else prev.next = new Node(key,value);
    }
    
    public int get(int key) {
       int idx = hash(key);
       if(storage[idx]==null)
       {
           return -1;
       }
       Node prev = find(storage[idx],key);
       if(prev.next==null)
           return -1;
       return prev.next.value;
        
    }
    
    public void remove(int key) {
          int index = hash(key);
       if(storage[index]==null)
       {
           return;
       }
       Node prev = find(storage[index],key);
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