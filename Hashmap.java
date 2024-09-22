// Time Complexity: O(1).


class MyHashMap {
    int buckets;
    Node[] storage;
    
    class Node{
        int key;
        int value;
        Node next;
        
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    public MyHashMap() {
        this.buckets=10000;
        this.storage= new Node[buckets];
        
    }
    
    private int getHash(int key){
        return key % buckets;
    }
    
    private Node getPrev(Node head,int key){
        Node prev=null;
        Node curr=head;
        
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        
        return prev;
    }
    
    public void put(int key, int value) {
        int hash=getHash(key);
        if(storage[hash]==null){
            storage[hash]=new Node(-1,-1);
        }
        Node prev=getPrev(storage[hash],key);
        if(prev.next==null){
            prev.next=new Node(key,value);
        }else{
            prev.next.value=value;
        }
        
    }
    
    public int get(int key) {
        int hash=getHash(key);
        if(storage[hash]==null){
            return -1;
        }
        Node prev=getPrev(storage[hash],key);
        if(prev.next==null){
            return -1;
        }else{
            return prev.next.value;
        }
        
    }
    
    public void remove(int key) {
        int hash=getHash(key);
        if(storage[hash]==null){
            return;
        }
        Node prev=getPrev(storage[hash],key);
        if(prev.next==null){
            return;
        }
        Node curr=prev.next;
        prev.next=curr.next;
        curr.next=null;
        
    }
}
