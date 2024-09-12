/**Time Complexity :
    O(1)
// Space Complexity :
    O(n)
// Did this code successfully run on Leetcode :
    Yes
// Any problem you faced while coding this :   
    Faced a little problem with find method to understand the pointers
// Your code here along with comments explaining your approach
**/


class MyHashMap {
    
    //create Node
    class Node{
        int key,value;
        Node next;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    Node[] nodes;
    int buckets;
    
    //initialization
    public MyHashMap() {
        buckets=1000;
        nodes=new Node[buckets];
    }

    //To find bucket
    private int getBucket(int key){
        return key % buckets;
    }

    //Find method which returns a prev node of the required node.
    private Node find(Node head, int key){
       Node prev=head;
       Node curr=head.next;
       while(curr!=null && curr.key!=key){
           prev=curr;
           curr=curr.next;
       }
        return prev;
    }

    //To insert node check if index null means initialization of header. If bucket is there, then find prev and create new node next to it. If the key exists then update the value.
    public void put(int key, int value) {
        int index=getBucket(key);
        if(nodes[index]==null){
            nodes[index]=new Node(-1,-1);
        }
        Node prev=find(nodes[index],key);
        if(prev.next==null){
            prev.next=new Node(key,value);
        }
        else{
            prev.next.value=value;
        }
    }
    
   //find prev node and return next value which is the actual node to find
    public int get(int key) {
        int index=getBucket(key);
        if(nodes[index]==null){
            return -1;
        }
        Node prev=find(nodes[index],key);
        if(prev.next==null){
            return -1;
        }
        return prev.next.value;
        
    }

     //Find the prev node and assign next value as next of node which needs to be deleted
    public void remove(int key) {
        int index=getBucket(key);
        if(nodes[index]==null){
            return;
        }
        Node prev=find(nodes[index],key);
        if(prev.next==null){
            return;
        }
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