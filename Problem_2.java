//Leetcode problem  - 705
// Time Complexity : add(), remove() , contain() - O(n) for worst case scenario
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Want to implement more optimized solution like BST and Double Hashing


// Your code here along with comments explaining your approach
/** Implementation is same as the implementation for designing hashmap. Used Chaining method to avoid collisions. Arrays is used with a particular hashcode (corresponding to each key input) for each array index. Each index is having LinkedList. 
*/
class MyHashSet {

    /** Initialize your data structure here. */
    Node[] buckets;
    
    class Node{
        int key;
        Node next;
        
        Node(int key){
            this.key = key;
            this.next = null;
        }
    }
    public MyHashSet() {
        buckets = new Node[10000];
    }
    
    /** Calculated hashcode based on key. Traversed to that particular index in array. Checked if there is any node at that index, if not, add that node, else, check if the key exist in any of the node to that particular Linked List. If key exists, return from the function. If key doesn't exist, add the key as the last node.
    */
    public void add(int key) {
        Node newNode = new Node(key);
        int hash = key % 10000;
        Node currentBucket = buckets[hash];
        Node ptr = currentBucket;
        Node prev = null;
        
        if(ptr == null)
            buckets[hash] = newNode;
        else{
            
            while(ptr != null){
                if(ptr.key == newNode.key){
                  return;  
                }
              
              prev = ptr; 
              ptr= ptr.next;
             
            }
            
            prev.next = newNode;
            

        }
    }


    /** Calculated hashcode based on key. Traversed to that particular index in array. Check if that key exists in any of the node in the list. Remove the node from the last and move the reference of node previous to it to the next node.
    */
    public void remove(int key) {
        int hashCode = key % 10000;
        Node currentBucket = buckets[hashCode];
        Node ptr = currentBucket;
        if(ptr == null)
            return;
        Node prev = null;
        
       
         while(ptr!= null){
            if(ptr.key == key){
                if(prev != null)
                    prev.next = ptr.next;
                else
                    buckets[hashCode] = ptr.next;
                
                ptr.next = null;
                
            }
            
            prev = ptr;
            ptr = ptr.next;
           
        }
    }
    
    
    /** Returns true if this set contains the specified element */
    /**Calculated hashcode based on key. Traversed to that particular index in array. Check if that key exists,return true, otherwise false.
    */
    public boolean contains(int key) {
         int hashCode = key % 10000;
        Node currentBucket = buckets[hashCode];
        Node ptr = currentBucket;
        while(ptr!= null){
            if(ptr.key == key)
                return true;
            
            ptr = ptr.next;
            
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