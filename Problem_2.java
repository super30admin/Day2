// Time Complexity : O(1)
// Space Complexity : O(n) where n is upper limit of accepted key value
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.Arrays;

class MyHashSet {
    static int[][] arr;

    public MyHashSet() {
        arr = new int[1000][1001];
        for (int[] row : arr)
            Arrays.fill(row, -1);

    }

    public void add(int key) {
        if (!contains(key)) {
            int outerValue = key % 1000;
            int innerValue = key / 1000;
            arr[outerValue][innerValue] = key;
        }
    }

    public void remove(int key) {
        if (contains(key)) {
            int outerValue = key % 1000;
            int innerValue = key / 1000;
            arr[outerValue][innerValue] = -1;
        }
    }

    public boolean contains(int key) {
        int outerValue = key % 1000;
        int innerValue = key / 1000;
        if (arr[outerValue][innerValue] == key) {
            return true;
        } else {
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