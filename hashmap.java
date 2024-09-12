// Time Complexity : O(n/k) n is arr size and k is size of linked list
// Space Complexity : O(x+k) x is unique keys k is size of linked list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {

    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    
    int buckets;
    Node [] nodes;
    
    public MyHashMap() {
        buckets=10000;
        nodes=new Node[buckets];
    }
    
    private Node find(Node head, int key){
        Node prev=head;
        Node curr=head.next;
        while(curr!=null &&curr.key!=key){ //traverse to find tail of linked list
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    private int getHash(int key){  
        return Integer.hashCode(key)%buckets;  //to ensure within bound of buckets 
        //or just key % buckets;
    }
    
    public void put(int key, int value) {
        int index=getHash(key);
        if(nodes[index]==null){
            nodes[index]=new Node(-1,-1); //dummy node 
        }
        Node prev=find(nodes[index], key);
        if(prev.next==null){
            prev.next=new Node(key,value); //new node is initialized 
        }
        else prev.next.value=value; //just update value 
    }
    
    public int get(int key) {
        int index=getHash(key);
        if(nodes[index]==null){
            return -1;
        }
        Node prev=find(nodes[index], key);
        if(prev.next==null){
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index=getHash(key);
        if(nodes[index]==null){
            return;
        }
        Node prev= find(nodes[index], key);
        if(prev.next==null){
            return;
        }else prev.next=prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */