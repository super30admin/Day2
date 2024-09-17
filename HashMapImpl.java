// Time Complexity : o(n/k) k = is linkedlist size and n is size of array
// Space Complexity : worst => o(x + k) k = is linkedlist size and x is unique keys
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;
        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }
    
    int arrSize;
    Node []nodeArr;
    public MyHashMap() {
        arrSize = 10000;
        nodeArr = new Node[arrSize];
    }
    
    //returns index
    public Node find(Node head, int key) {
        Node prev = head;
        Node curr = head.next;
        
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
    
    //o(n)
    public void put(int key, int value) {
        int idx = key % arrSize;
        if(nodeArr[idx] == null) {
            nodeArr[idx] = new Node(-1, -1);
        }
        
        Node prev = find(nodeArr[idx], key);
        
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int idx = key % arrSize;
        if(nodeArr[idx] == null) {
            return -1;
        }
        Node prev = find(nodeArr[idx], key);
        if(prev.next == null) {
            return -1;
        }
        return prev.next.val;
    }
    
    public void remove(int key) {
        int idx = key % arrSize;
        if(nodeArr[idx] == null) {
            return ;
        }
        Node prev = find(nodeArr[idx], key);
        if(prev.next == null) {
            return ;
        }
        prev.next = prev.next.next;
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */