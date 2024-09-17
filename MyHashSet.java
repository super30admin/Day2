// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Missed a condition in the remove() method. Had to look up yesterdays Hashmap video to 
//											check what I missed


// Your code here along with comments explaining your approach

class MyHashSet {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    Node[] bucket =new Node[10000];
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int hashValue = key%bucket.length;
        if(bucket[hashValue]== null)
            bucket[hashValue]= new Node(key);
        else{
            Node node = bucket[hashValue];
            while(node.next!=null && node.data!=key)
                node=node.next;
            if(node.data!=key)
                node.next =new Node( key);
        }
    }
    
    public void remove(int key) {
        int hashValue = key%bucket.length;
        if(bucket[hashValue]==null)
            return;
        if(bucket[hashValue].data == key){
           bucket[hashValue]=bucket[hashValue].next;
            return;
        }
        Node node=bucket[hashValue];
        Node previous = null;
        while(node.next!=null && node.data!=key ){
            previous=node;
            node=node.next;
        }
        if(node.data == key){
            if(previous!= null){
                previous.next=node.next;
            }
            else
                bucket[hashValue]=null;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        int hashValue = key%bucket.length;
        if(bucket[hashValue]==null)
            return false;
        
        Node node=bucket[hashValue];
        
        while(node!=null ){
            if(node.data==key)
                return true;
            node=node.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */