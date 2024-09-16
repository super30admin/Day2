// Time Complexity : For all operations its O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class MyHashSet {
    int rows = 1000;
    int columns = 1000;
    boolean[][] storage = new boolean[rows][]; 
/** Initialize your data structure here. */
public MyHashSet() {
    
}
private int rowHash (int key){
    return key % rows;
}
private int columnHash (int key){
    return key / columns;
}
public void add(int key) {
    int rowHash = rowHash(key);
    int columnHash = columnHash(key);
    if (storage[rowHash] == null){
        storage [rowHash] = new boolean[columns];
    }
    storage[rowHash][columnHash] = true;
}

public void remove(int key) {
    int rowHash = rowHash(key);
    int columnHash = columnHash(key);
    if (storage[rowHash] != null){
        storage[rowHash][columnHash] = false;
    }
}

/** Returns true if this set contains the specified element */
public boolean contains(int key) {
     int rowHash = rowHash(key);
    int columnHash = columnHash(key);
    if (storage[rowHash] != null){
        return storage[rowHash][columnHash];
    }else{
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