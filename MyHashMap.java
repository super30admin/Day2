// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class MyHashMap {
    
    //creating Node
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key =key;
            this.value=value;
        }
    }
Node[] nodes;
    private int buckets;
    private int getBucket(int key){
        return Integer.hashCode(key)% buckets; //hashing function
    }
    public MyHashMap() {
        buckets=1000;
        nodes= new Node[buckets];
    }
    
    //to find the node
    private Node find(Node node, int key){
        Node prev =node;
        Node curr = node.next;
        while (curr!=null && curr.key !=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int  bucket = getBucket(key);
        if(nodes[bucket]== null){
            nodes[bucket]=new Node(-1,-1); //dummy node
        }
        Node prev= find(nodes[bucket],key);
        if(prev.next == null){
            prev.next = new Node(key,value); //if prev.next is null create node
        }
        else{
            prev.next.value =value; //assign the value to prev.next.value
        }
    }
    
    public int get(int key) {
        int bucket =getBucket(key);
        if(nodes[bucket]== null){ //if bucket is null
            return -1;
        }
        Node prev =find(nodes[bucket],key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket= getBucket(key);
        //handling null conditions
        if(nodes[bucket]==null){ 
            return;
        }
        Node prev= find(nodes[bucket],key);
        if(prev.next== null){
            return;
        }
        Node temp= prev.next;
        prev.next=prev.next.next;
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