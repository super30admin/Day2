// Time Complexity : O(1) for all operations
// Space Complexity : O(10^6)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
    int[] hash;
    public MyHashSet() {
       hash = new int[1000001];
    }
    
    public void add(int key) {
        hash[key]=1;
    }
    
    public void remove(int key) {
        hash[key]=0;
    }
    
    public boolean contains(int key) {
        if(hash[key]==0)
            return false;
        else 
            return true;
    }
}

/**
Used an array of size 10^6.
 */