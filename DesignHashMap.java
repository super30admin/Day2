// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :While I try to get the value associated with a key , it always returned me -1. 
// This is because I wasn't getting the prev pointer value correctly. I fixed the logic to get a previous pointer value correctly to resolve this.


// Approach followed is Linear Chaining. To solve this problem identify the previous pointer when the key value matches & when node value is null
// With the previous pointer put/get the current key passed as an input.
// For remove traverse until key value matches and updated prev pointer next to current.next.
class MyHashMap {
    class Node {
        public int key;
        public int value;
        public Node next;
        public Node(int key, int value){
            this.value=value;
            this.key=key;
        }
    }
    private Node[] hashMap;    
    private int primaryBucketSize;


    public MyHashMap() {    
        primaryBucketSize=10000;
        hashMap=new Node[primaryBucketSize];   
    }

    private int getHashValue(int key){
        return key%primaryBucketSize;
    }
 //Traverse until the key value matches with the current key.Then return the previous Value.   
    private Node prevValue(int hashValue, int key){
          Node curr=hashMap[hashValue];;
          Node prev=null;
          while(curr!=null && curr.key !=key){
             prev=curr;
             curr=curr.next;
          }
          return prev;
    }

    public void put(int key, int value) {
        int hashValue=getHashValue(key);
        if(hashMap[hashValue]==null) {
            hashMap[hashValue]=new Node(-1, -1);
        } 
          Node prev=prevValue(hashValue, key);        
          if(prev.next==null)
          {
            prev.next=new Node(key, value); 
          } else{
            prev.next.value=value;
          }                                        
    }
    
    public int get(int key) {
        int value=getHashValue(key);
        if(hashMap[value]==null){
            return -1;
        }
        Node prev=prevValue(value, key);
        if(prev.next==null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int value=getHashValue(key);        
        if(hashMap[value]!=null){
            Node prev=new Node(-1,-1);
            Node curr=hashMap[value];                   
            while(curr!=null){                
                if(curr.key==key){
                    prev.next=curr.next;
                    return;
                }
                prev=curr;
                curr=curr.next;
            }                        
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