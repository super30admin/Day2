// Time Complexity : The time complexities for add, remove and contains operations is O(1) because they are done by directly accessing the index
// Space Complexity : The space complexity is O(n) since in worst case scenario all the elements in the arrays would be full
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {

    boolean[][] set;

    /** Initialize your data structure here. */
    public MyHashSet() {

        // Since the maximum number of elements would be 10^6, an array of length 1000 is created and each index would
        // manage another array of length 1000
        set = new boolean[1000][];

    }

    public void add(int key) {

        // Index of the first and second arrays is obtained through hashing
        int index = key % set.length;
        int secondIndex = key / set.length;

        // If the array is empty then a new array is created
        if(set[index] == null){
            set[index] = new boolean[1000];
            set[index][secondIndex] = true;
            return;
        }

        // Add the key in the set
        set[index][secondIndex] = true;

    }

    public void remove(int key) {

        // Index of the first and second arrays is obtained through hashing
        int index = key % set.length;
        int secondIndex = key / set.length;

        // If the array is empty then there are no elements to remove
        if(set[index] == null){
            return;
        }
        // Remove the key in the set
        set[index][secondIndex] = false;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {

        // Index of the first and second arrays is obtained through hashing
        int index = key % set.length;
        int secondIndex = key / set.length;

        // If the array is empty then the key doesnt exists
        if(set[index] == null){
            return false;
        }

        return set[index][secondIndex];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */