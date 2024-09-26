/*
 Time Complexity : O(1)
 Space Complexity : O(n)
 Did this code successfully run on Leetcode : Yes
*/
class MyHashMap {

     class Node {
        int key; int val;
        Node next;
        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node[] nodes;
    
    private int getBucket(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
    
    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    private Node find(Node head, int key) {
        Node curr = head;
        Node prev = null;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int i = getBucket(key);
        if (nodes[i] == null) {
            nodes[i] = new Node(-1, -1);
        }
        Node prev = find(nodes[i], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int i = getBucket(key);
         if(nodes[i] == null) return -1;
        Node prev = find(nodes[i], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int i = getBucket(key);
        if(nodes[i] == null) return;
        Node prev = find(nodes[i], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
