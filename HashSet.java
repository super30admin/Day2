// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {
    
    private boolean[][] map;
    int outerSize;
    int innerSize;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new boolean[1000][];
        outerSize = 1000;
        innerSize = 1000;
    }
    
    private int outerHash(int key){
        return key % outerSize;
    }
    
    private int innerHash(int key){
        return key / innerSize;
    }
    
    public void add(int key) {
        int outIndex = outerHash(key);
        int inIndex = innerHash(key);
        if(map[outIndex] == null){
            if(outIndex == 0){
                map[outIndex] = new boolean[innerSize+1];
            }
            else{
                map[outIndex] = new boolean[innerSize];
            }
        }
        map[outIndex][inIndex] = true;
    }
    
    public void remove(int key) {
        int outIndex = outerHash(key);
        int inIndex = innerHash(key);
        if(map[outIndex] == null) return;
        map[outIndex][inIndex] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int outIndex = outerHash(key);
        int inIndex = innerHash(key);
        if(map[outIndex] == null) return false;
        return map[outIndex][inIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */