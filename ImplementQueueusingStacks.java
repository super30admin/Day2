//Time Complexity :o(1)
// Space Complexity :o(n) 
// Did this code successfully run on Leetcode : it runs good in leat code
// Any problem you faced while coding this : no

class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    private Node [] storage;
    public MyHashMap() {
        this.storage=new Node[10000];
    }
    private int hashIdx(int key){
        return key%10000;
    }
    private Node search(Node head,int key){
        // give me the prev node to the current that we are searching
    Node prev = head;
    Node curr=head.next;
    while(curr!=null && curr.key!=key){
        prev=curr;
        curr=curr.next;
    }
    return prev;
    }
    
    public void put(int key, int value) {
        int idx=hashIdx(key);
        if (storage[idx]==null){
            storage[idx]=new Node(-1,-1);
        }
        //nonfresh node
        Node prev = search(storage[idx],key);
        if(prev.next!=null){
            prev.next.val=value;
        }else{
            prev.next=new Node(key,value);
        }


    }
    
    public int get(int key) {
        int idx= hashIdx(key);
         if (storage[idx]==null) return -1;
         Node prev = search(storage[idx],key);
          if(prev.next==null) {
            return -1;
          }else{
            return prev.next.val;
    }
    }
    
     public void remove(int key) {
         int idx = hashIdx(key);
         if (storage[idx]==null) return ;
          Node prev =search(storage[idx],key);
          if(prev.next==null) return;
          Node temp = prev.next;
          prev.next=prev.next.next;//temp.next
          temp.next=null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */