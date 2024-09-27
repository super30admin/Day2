import java.util.LinkedList;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.

class MyHashSet {

    //Int linked list used for storing the data
    LinkedList <Integer>[] ll;
    int size =1000;
    
    /** Initialize your data structure here. */

    public MyHashSet() {
        ll = new LinkedList[size];
    }
    
    public void add(int key) {
        
        int i; // Indexing the LL
        i = key % size;
        // Create a LL if it doesn't exist
        if (ll[i] == null) ll[i] = new LinkedList<>();

        if(ll[i].indexOf(key) < 0) {
            // Add the key to the LL if the LL is empty
            ll[i].add(key);
        }
        
    }
    
    public void remove(int key) {
        int i = key % size;
        if(ll[i] == null || ll[i].indexOf(key) == -1) return;   //cannot remove from empty LL or if the key was not found
        ll[i].remove(ll[i].indexOf(key));
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = key % size;
        if(ll[i] == null || ll[i].indexOf(key) == -1) return false;   //does not contain the element or is an empty LL
        
        return true; // key was found
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
