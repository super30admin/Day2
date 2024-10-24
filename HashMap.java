class MyHashMap {

    class Node {
     int key;
     int value;
     Node next;
     public Node(int key, int value){
        this.key=key;
        this.value=value;
     }
  } 
     Node[] s;
     int bucket=10000;
    public MyHashMap() {
      
        this.bucket=10000;
        this.s=new Node[bucket]; 
    }
    int getHash(int key){
        return key % bucket;
    }
    Node getPrev(Node head, int key){
        Node prev=null;
        Node curr=head;
        if(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int idx=getHash(key);
        if(s[idx]==null)
           s[idx]=new Node(-1,-1);
        Node prev=getPrev(s[idx],key);
        if(prev.next==null)
            prev.next= new Node(key,value);
        else{
            prev.next.value=value;
        }
    }
    
    public int get(int key) {
        int idx=getHash(key);
        if(s[idx]==null){
           return -1;
        }
        Node prev=getPrev(s[idx],key);
        if(prev.next==null){
            return -1;
        }
       
          return prev.next.value;
    }
    
    public void remove(int key) {
        int idx=getHash(key);
        if(s[idx]==null){
          return;
        }
        Node prev=getPrev(s[idx],key);
        if(prev.next==null){
          return;
        }
        Node cur=prev.next;
        prev.next=cur.next;
        cur=null;
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */