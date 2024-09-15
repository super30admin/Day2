// Time Complexity :getBucket is O(1), find is O(N), put is O(1), get is O(1), remove is O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class MyHashMap {
    
    class Node{
        int value, key;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    Node[] nodes;
    private int buckets;

    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
        
    }
    
    private int getBucket(int key){
        return Integer.hashCode(key) % buckets;
    }
    
    private Node find(Node node, int key){
        Node prev = node;
        Node curr = node.next;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(nodes[bucket] == null){
            nodes[bucket] = new Node(-1,-1);
        }
        Node prev = find(nodes[bucket],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        if(nodes[bucket] == null){
            return -1;
        }
        Node prev = find(nodes[bucket],key);
        if(prev.next == null){
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        if(nodes[bucket] == null){
            return;
        }
        Node prev = find(nodes[bucket],key);
        if(prev.next == null){
            return;
        }
        //Node temp = prev.next;
        prev.next = prev.next.next;
        //temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
