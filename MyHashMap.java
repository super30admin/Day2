// Time Complexity :
// put() - O(N) in worst case, ideally O(1)
// get() - O(N) in worst case, ideally O(1)
// remove() - O(N) in worst case, ideally O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
// Array with Nodes and hashing function to get the index
class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    
    Node arr[];
    public MyHashMap() {
        arr = new Node[1000];
    }
    
    private Node find(Node head, int key)
    {
        Node prev = head;
        Node curr = head.next;
        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev; 
    }

    private int hashingFun(int key)
    {
        return key % 1000;
    }
    
    public void put(int key, int value) {
        int index = hashingFun(key);
        if(arr[index] == null) {
            arr[index] = new Node(-1, -1);
        }
        Node prev = find(arr[index], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        }
        else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = hashingFun(key);
        if(arr[index] == null) {
            return -1;
        }
        Node prev = find(arr[index], key);
        if(prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = hashingFun(key);
        if(arr[index] == null) {
            return;
        }
        Node prev = find(arr[index], key);
        if(prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }
}
