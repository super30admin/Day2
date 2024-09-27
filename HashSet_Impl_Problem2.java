// Time Complexity : add - O(1), remove - O(1), contains - O(1)
// Space Complexity : O(1) - If given stack is excluded
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyHashSet {
    int[][] arr;

    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new int[1000][];
    }
    
    public void add(int key) {
        int hashKeyIndex = hashKeyIndex(key);
        int hashKey = hashKey(key); 
        if(arr[hashKeyIndex] == null){
            arr[hashKeyIndex] = new int[1000];
            Arrays.fill(arr[hashKeyIndex],-1);
        }
        arr[hashKeyIndex][hashKey] = key;
    }
    
    public void remove(int key) {
        int hashKeyIndex = hashKeyIndex(key);
        int hashKey = hashKey(key); 
        if(arr[hashKeyIndex] != null){
            arr[hashKeyIndex][hashKey] = -1;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashKeyIndex = hashKeyIndex(key);
        int hashKey = hashKey(key); 
        if(arr[hashKeyIndex] != null){
            return arr[hashKeyIndex][hashKey] != -1;
        }else{
            return false;
        }    
    }
    
    public int hashKey(int key){
        return key%1000;
    }
    public int hashKeyIndex(int key){
        return key/1000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */