// Time Complexity :   add(), remove(), contains()  ->  O(1)
// Space Complexity :  O(n) I am using HashMap to simulate the behavior
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class MyHashSet {
    
    HashMap<Integer, Integer> index;        // Using HashMap to simulate the Hashset behavior

    /** Initialize your data structure here. */
    public MyHashSet() {
        index = new HashMap<>();
    }
    
    public void add(int key) {
        if(!index.containsKey(key)){            // Checking duplicates, if the key does not exists, then only add Key: Key(value) 
        index.put(key,key);
        }
    }
    
    public void remove(int key) {
        if(index.containsKey(key)){
        index.remove(key);                      // If key to key mapping exists, remove the key from the map
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(index.containsKey(key)){             // Check if key exists in the map
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */