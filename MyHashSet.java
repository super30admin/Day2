// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

import java.util.ArrayList;

class MyHashSet {

    int listSize = 1000;
    ArrayList[] hashList = new ArrayList[listSize];

    public MyHashSet() {
        for (int i = 0; i < listSize; ++i) {
            hashList[i] = new ArrayList<>();
        }
    }

    public void add(int key) {
        if (!contains(key)) {
            int idx = hashFunction(key);
            hashList[idx].add(key);
        }

    }

    public void remove(int key) {
        if (contains(key)) {
            int idx = hashFunction(key);
            int innerIdx = hashList[idx].indexOf(key);
            hashList[idx].remove(innerIdx);
        }

    }

    public boolean contains(int key) {
        int idx = hashFunction(key);
        return hashList[idx].contains(key);
    }

    public int hashFunction(int key) {
        return key % listSize;
    }
}