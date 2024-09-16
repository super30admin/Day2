// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashMap {

    class Node{
        int key, value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value=value;
        }
    }
    
     Node[] nodes;
    int buckets;
    
    private int getBucket(int key){
        return key % buckets;
    }
    
    private Node find(Node head, int key){
        Node prev = head;
        Node cur = head.next;
        while(cur!=null && cur.key!=key){
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
    
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }
    
    public void put(int key, int value) {
        int index = getBucket(key);
        if(nodes[index] ==  null){
            nodes[index] = new Node(key, value);
        }
        Node prev = find(nodes[index],key);
        if(prev.next == null)
            prev.next = new Node(key,value);
        else
            prev.next.value = value;      
    }
    
    public int get(int key) {
        int index = getBucket(key);
        if(nodes[index] ==  null)
            return -1;
        Node prev = find(nodes[index],key);
        if(prev.next == null)
            return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = getBucket(key);
        if(nodes[index] ==  null)
            return;
        Node prev = find(nodes[index],key);
        if(prev.next == null)
            return;
        prev.next = prev.next.next;
    }
}
