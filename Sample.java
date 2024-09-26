// Time Complexity : O(1) - add, remove and contains
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Taking 2D boolean array, initially primary bucket size is sqrt(total number of elements).
// and by doing hasing (key%length of array), 
// I'm finding primary array index value and changing respective secondary array by doing another hash function (key/size).
// For add, when you find the secondary index change it's value to true, which means element present
// For remove, when you find the secondary index change it's value to false, which means we removed the element
// For contains return the value in the secondary array.
class MyHashSet {
    
    boolean[][] container;
    int bucket;
    int bucketItems;

    public MyHashSet() {
        bucket = 1000;
        bucketItems = 1000;
        container = new boolean[bucket][];
    }
    
    public int getHash(int key) {
        return key%bucket;
    }
    
    
    public int getSecondHash(int key) {
        return key/bucketItems;
    }
    
    public void add(int key) {
        
        int index = getHash(key);
        int sIndex = getSecondHash(key);
        
        if(container[index] == null) {
             if(index == 0) {
                 // This is for last value (10**6)
                 container[index] = new boolean[bucketItems+1];
             }  else {
                 container[index] = new boolean[bucketItems];
             }
        }
        container[index][sIndex] = true;
    }
    
    public void remove(int key) {
         int index = getHash(key);
         int secondindex = getSecondHash(key);
        if(container[index] == null) {
            return;
        }
         container[index][secondindex] = false;
    }
    
    public boolean contains(int key) {
        int index = getHash(key);
        int secondindex = getSecondHash(key);
        if(container[index] != null) {
            return container[index][secondindex];
        } else {
            return false;
        }
        // return true;
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
