// Time Complexity :O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashMap {
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key= key;
            this.value= value;
        }
    }
    Node[] nodes;
    private int buckets;

    public MyHashMap() {
        buckets= 10000;
        nodes= new Node[buckets];
        
    }
    public int hashingfunc(int key){
        return Integer.hashCode(key) % buckets;
    }
    
    public Node find(Node node, int key){
        Node prev= node;
        Node curr= node.next;
        while(curr != null && curr.key != key){
            prev= curr;
            curr= curr.next;
        }
        return prev;
            
    }
    
    public void put(int key, int value) {
        int bucket= hashingfunc(key);
        if(nodes[bucket]== null){
            nodes[bucket]= new Node(-1,-1); //creating a dummy node
        }
        Node prev= find(nodes[bucket], key);
        if(prev.next== null){
            prev.next= new Node(key, value);
        }else{
            prev.next.value= value;
        }
        
    }
    
    public int get(int key) {
        int bucket= hashingfunc(key);
        if(nodes[bucket]== null){
            return -1;
        }
        Node prev= find(nodes[bucket], key);
        if(prev.next== null){
            return -1;
        }else{
            return prev.next.value;
        }
        
    }
    
    public void remove(int key) {
        int bucket= hashingfunc(key);
        if(nodes[bucket]== null){
            return;
        }
        Node prev= find(nodes[bucket], key);
        if(prev.next== null){
            return;
        }else{
            prev.next= prev.next.next;
            
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
    

