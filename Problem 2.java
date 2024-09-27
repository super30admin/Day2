// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes  
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class MyHashMap {

    class Node {
        int key,value;
        Node next;
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    Node nodes[];
    int buckets;
    
    private int getbucket(int key) {
        return key % 1000 ;
    }
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
        
    }
    private Node find(Node node, int key){
        Node prev = node;
        Node cur = node.next;
        while(cur != null && cur.key != key)
        {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = getbucket(key);
        if(nodes[bucket] == null)
        {
            nodes[bucket] = new Node(-1,-1);
        }
        Node prev = find(nodes[bucket],key);
        if(prev.next == null)
        {
            prev.next = new Node(key,value);
        }
        else
        {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int bucket = getbucket(key);
        if(nodes[bucket] == null)
        {
            return -1;
        }
        Node prev = find(nodes[bucket],key);
        if(prev.next == null)
        {
            return -1;
        }
        return prev.next.value;
        
    }
    
    public void remove(int key) {
        int bucket = getbucket(key);
        if(nodes[bucket] == null)
        {
            return;
        }
        Node prev = find(nodes[bucket],key);
        if(prev.next == null)
        {
            return;
        }
        else
        {
            prev.next = prev.next.next;
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