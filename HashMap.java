// Time Complexity : avg O(1) and worst case O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {
    int bucketSize = 10000;
    Node[] nodeArray;

    public MyHashMap() {
        this.nodeArray = new Node[bucketSize];
    }
    
    private int hashFunction(int key){
        return Integer.hashCode(key) % bucketSize;
    }
    
    private Node findNode(int key, int bucketIndex){
        Node prev = this.nodeArray[bucketIndex];
        Node curr = prev.next;
        
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
    
    public void put(int key, int value) {
        int bucketIndex = hashFunction(key);
        
        if(this.nodeArray[bucketIndex] == null){
            this.nodeArray[bucketIndex] = new Node(-1,-1);
        }
        
        Node prev = findNode(key, bucketIndex);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int bucketIndex = hashFunction(key);
        
        if(this.nodeArray[bucketIndex] == null){
            return -1;
        }
        
        Node prev = findNode(key, bucketIndex);
        if(prev.next == null){
            return -1;
        }
        else{
            return prev.next.value;
        }
    }
    
    public void remove(int key) {
        int bucketIndex = hashFunction(key);
        
        if(this.nodeArray[bucketIndex] == null){
            return;
        }
        
        Node prev = findNode(key, bucketIndex);
        if(prev.next == null){
            return;
        }
        else{
            prev.next = prev.next.next;
        }
    }
}

public class Node{
    public int key, value;
    public Node next;
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

