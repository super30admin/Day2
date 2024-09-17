// Time Complexity: O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: Could not come up with an optimized solution due to lack of time. 

class MyHashSet {

    /** Initialize your data structure here. */
    boolean[] arr;

    public MyHashSet() {
        arr = new boolean[1000001];
    }

    public void add(int key) {
        arr[key] = true;
    }

    public void remove(int key) {
        arr[key] = false;
    } 

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return arr[key];
    }
}