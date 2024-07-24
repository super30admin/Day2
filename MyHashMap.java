// Problem 706: Design HashMap
// Time Complexity :  O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
I have used Array. initializing with -1 to mark it empty. According to key value we will use array index to fill value.
same for get and for remove we will put -1 to mark it empty
*/

import java.util.Arrays;

class MyHashMap {

    static final int CAP = 1000001;
    private int[] ob;

    public MyHashMap() {
        ob = new int[CAP];
        Arrays.fill(ob, -1);
    }

    public void put(int key, int value) {
        ob[key] = value;
    }

    public int get(int key) {
        return ob[key];
    }

    public void remove(int key) {
        ob[key] = -1;
    }
}
