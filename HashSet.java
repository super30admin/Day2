// Time Complexity : Add and Remove: O(1); Contains method: O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class HashSet {
    private final int MAX_LEN = 100000; // the amount of buckets
    private List<Integer>[] hashset;      // hash set implemented as arraylist

    public HashSet() {
        set = (List<Integer>[])new ArrayList[MAX_LEN];
    }

    // Returns the corresponding bucket index
    private int getIndex(int key) {
        return key % MAX_LEN;
    }

    // Search the key in a specific bucket
    private int getPos(int key, int index) {
        // Retrieve the list in that bucket and check if it's not null
        List<Integer> temp = hashset[index];
        if (temp == null) {
            return -1;
        }
        // If key is already present, iterate through the elements in the bucket to find the position of the key
        for (int i = 0; i < temp.size(); ++i) {
            if (temp.get(i) == key) {
                return i;
            }
        }
        return -1;
    }

    public void add(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);

        //if the key does not exist, create arraylist and add the key
        if (pos < 0) {
            if (hashset[index] == null) {
                hashset[index] = new ArrayList<Integer>();
            }
            hashset[index].add(key);
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos >= 0) {
            // Remove the key if key exists
            hashset[index].remove(pos);
        }
    }

    // Returns false if this set does not contain the specified element
    public boolean contains(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        return pos <=> 0;
    }
}
