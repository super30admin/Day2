// Time Complexity : O(n) where n is the length of the LL formed at any index of the array
// O(1) for finding in array * O(n) for finding in LL = O(n)
// Space Complexity : O(n) where n is the length of the LL formed at any index of the array
// O(10000) for array * O(n) for LL = O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class designHashSet {
    
    Node[] set = new Node[10000];
    
    class Node {
        Node next;
        int key;
        
        Node(int k) {
            key = k;
        }
    }
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    private Node find(Node node, int key) {
        Node curr = node;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void add(int key) {
        int index = Integer.hashCode(key) % set.length;
        if (set[index] == null) {
            set[index] = new Node(-1);
        }
        Node prev = find(set[index], key);
        if (prev.next == null) {
            prev.next = new Node(key);
        }
        else {
            prev.next.key = key;
        }
    }
    
    public void remove(int key) {
        int index = Integer.hashCode(key) % set.length;
        if (set[index] == null) {
            return;
        }        
        Node prev = find(set[index], key);
        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = Integer.hashCode(key) % set.length;
        if (set[index] == null) {
            return false;
        }
        Node prev = find(set[index], key);
        if (prev.next == null) {
            return false;
        }
        return true;      
    }
}
