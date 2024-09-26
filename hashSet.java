// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

import java.util.*;

class DesignHashSet {

    int[][] hashset; 
    int hashsetSize = 1000;
    int listSize = 1001;

    public DesignHashSet() {
        hashset = new int[1000][];
    }

    private int hashKey(int key) {
        int hashKey = key % hashsetSize;
        return hashKey;
    }

    private int listIndex(int key) {
        return key / listSize;
    }

    public void add(int key) {

        int hashKey = hashKey(key);
        int listIndex = listIndex(key);

        if (hashset[hashKey] == null) {
            hashset[hashKey] = new int[listIndex];

        }
        hashset[hashKey][listIndex] = key;
    }

    public void remove(int key) {
        int hashKey = hashKey(key);
        int listIndex = listIndex(key);

        if (hashset[hashKey] == null) {
            return;
        }
        // existing
        if (hashset[hashKey][listIndex] != -1) {
            hashset[hashKey][listIndex] = -1;
        }
       
    }

    public boolean contains(int key) {
        int hashKey = hashKey(key);
        int listIndex = listIndex(key);

        if (hashset[hashKey] == null) {
            return false;
        }
        if (hashset[hashKey] != -1) {
            return true;
        } else {
            return false;
        }
    }
}