// Time Complexity : O(1)
// Space Complexity : O(n) where n is the size of nested array
// Did this code successfully run on Leetcode : No (Requesting feedback help from TA)
// Any problem you faced while coding this : Yes (only 28/37 testcases passed)


// Your code here along with comments explaining your approach

class MyHashMap {
    private int[][][] storage;
    private int size;

    public MyHashMap() {
        this.size = 1000;
        this.storage = new int[size][][];
    }

    private int primaryHashIndex(int key) {
        return key % size;
    }

    private int secondaryHashIndex(int key) {
        return key / size;
    }

    public void put(int key, int value) {
        int primaryIndex = primaryHashIndex(key);
        if (primaryIndex == 0) {
            storage[primaryIndex] = new int[size + 1][2];
        } else if (storage[primaryIndex] == null) {
            storage[primaryIndex] = new int[size][2];
        }

        int secondaryIndex = secondaryHashIndex(key);
        storage[primaryIndex][secondaryIndex] = new int[]{key, value};
    }

    public int get(int key) {
        int primaryIndex = primaryHashIndex(key);
        if (storage[primaryIndex] == null) {
            return -1;
        }

        int secondaryIndex = secondaryHashIndex(key);
        if (storage[primaryIndex][secondaryIndex] == null) return -1;

        return storage[primaryIndex][secondaryIndex][1];
    }

    public void remove(int key) {
        int primaryIndex = primaryHashIndex(key);
        if (storage[primaryIndex] != null) {
            int secondaryIndex = secondaryHashIndex(key);
            storage[primaryIndex][secondaryIndex] = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */