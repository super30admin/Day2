// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
class MyHashSet {

    boolean set[] = new boolean[100];

    public MyHashSet() {

    }
    
    // Time Complexity : Average case -> O(1); Worst case -> O(N)
    public void add(int key) {
        if (key >= set.length) {
            set = increaseCapacity(set, key);
        }
        set[key] = true;
    }

    // Time Complexity : O(1)
    public void remove(int key) {
        if (key >= set.length) {
            return;
        }
        set[key] = false;
    }

    // Time Complexity : O(1)
    public boolean contains(int key) {
        if (key >= set.length) {
            return false;
        }

        return set[key];
    }

    public static boolean[] increaseCapacity(boolean arr[], int capacity) {
        boolean temp[] = new boolean[capacity * 2];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (i < arr.length) ? arr[i] : false;
        }
        return temp;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
