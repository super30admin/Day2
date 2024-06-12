// Time Complexity :-
//      Get - O(1)
//      Put - O(1)
//      Remove - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {

    boolean[][] matrix;
        
    public MyHashSet() {
        matrix = new boolean[1000][]; 
    }
    
    public int getHashKey(int key){
        return key % 1000;                  // Since the range is from 0-10^6, we intend on using a 1000*1001 matrix at the worst case
    }
    
    public int getHashKey2(int key){
        return key / 1001;                  // To accomodate the last value 10^6 and to avoid overflow, we use 1001, instead of 1000
    }
    
    public void add(int key) {
        int hashKey = getHashKey(key);
        int hashKey2 = getHashKey2(key);
        if (matrix[hashKey] == null){
            matrix[hashKey] = new boolean[1001];
        }
        matrix[hashKey][hashKey2] = true;
    }
    
    public void remove(int key) {
        int hashKey = getHashKey(key);
        int hashKey2 = getHashKey2(key);
        if (matrix[hashKey] == null) return;     // In case the Nested Array is not present, no operation is performed
        matrix[hashKey][hashKey2] = false;       // While removing the value, we set the default value false
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashKey = getHashKey(key);
        int hashKey2 = getHashKey2(key);
        if (matrix[hashKey] == null) return false; // In case the Nested Array is not present, we return the default value false
        return matrix[hashKey][hashKey2];           
    }
}

