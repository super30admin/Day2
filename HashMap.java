// Time Complexity : put: O(1), get: O(1), remove: O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

import java.util.Arrays;

public class HashMap {
    int[] arr;
    public HashMap() {
        arr = new int[1000001]; // here we have initialized array with 10 power 6 plus 1,to handle arrayOutOfBoundException
        Arrays.fill(arr, -1); // we used inbuilt function Arrays.fill to fill the given array with one same value
    }

    public void put(int key, int value) {
        arr[key] = value; // we have to modify the index of the arr with given key and value
    }

    public int get(int key) {
        return arr[key];
    }

    public void remove(int key) {
        arr[key] = -1; // set value to -1 to the given index of the key
    }
}