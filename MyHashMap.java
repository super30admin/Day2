// Time Complexity : O(n) for put,get and remove operations
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach :
  // We will be using array of buckets and each bucket will point to the linked list


public class MyHashMap {

	class Node{
        int key, value;
        Node next;

        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
        
    }
	int buckets;
	Node []storage;

    int getBucket(int key){
        return Integer.hashCode(key) % this.buckets;
    }

    private Node find(Node dummy,int key){
        Node prev=dummy;
        Node curr = dummy.next;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }

    public MyHashMap() {
        this.buckets = 1000;
        storage =new Node[this.buckets];
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket]==null){
            storage[bucket]=new Node(-1,-1);
        }
        Node prev = find(storage[bucket],key);
        if(prev.next!=null){
            prev.next.value=value;
        }else{
            prev.next = new Node(key,value);
        }
    }
    
    public int get(int key) {
        int bucket =getBucket(key);
        if(storage[bucket]==null)
          return -1;
        Node prev =find(storage[bucket],key);
        if(prev.next==null){
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket =getBucket(key);
        if(storage[bucket]==null){
            return;
        }
        Node prev = find(storage[bucket],key);
        if(prev!=null){
            prev.next=prev.next.next;
        }
        
    }
    
    
    /*public static void main(String[] args) 
    { 
    	MyHashMap obj = new MyHashMap();
    	 obj.put(1,100);
    	  int param_2 = obj.get(1);
    	  obj.remove(1);
    }*/ 

}
