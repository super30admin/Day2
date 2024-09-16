// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

class MyHashMap {
    
    class Node{
        int key, value;
        Node next;
        
        public Node(int key, int value){
            this.key =key;
            this.value = value;
        }   
    }
    
    Node[] nodes; 
    private int buckets;
    
    private int getBucket(int key){
        return Integer.hashCode(key)%buckets;
    }
    
    public MyHashMap() {
        buckets =1000;
        nodes =new Node[buckets]; 
    }
    
    private Node find(Node node, int key){
        Node prev =node;
        Node curr = node.next;
        while(curr != null && curr.key !=key){
            prev =curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
     int bucket = getBucket(key);
        //linked list doesnot exists 
        if(nodes[bucket] == null){
            //create a dummy node
            nodes[bucket] = new Node(-1, -1);
        }
        //find the node
        Node prev = find(nodes[bucket],key);
        //the key does not exists 
        if (prev.next ==null){
            prev.next =new Node(key, value);
        }
        //key exists 
        else{
            prev.next.value =value;
        }
    }
    
    public int get(int key) {
        int bucket =getBucket(key);
        if(nodes[bucket]==null){
            return -1;
        }
       Node prev = find(nodes[bucket],key);
        if(prev.next ==null){
            return -1;
        }
    return prev.next.value;
    }
    
    public void remove(int key) {
       int bucket =getBucket(key); 
        //key does not exist 
        if(nodes[bucket] == null){
            return;
        }
        //key may or maynot exists, so find 
        Node prev = find(nodes[bucket],key);
        //node does not exists
        if(prev.next == null){
            return;
        }
        //node exists
        Node temp =prev.next;
        prev.next =prev.next.next;
        temp.next =null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */