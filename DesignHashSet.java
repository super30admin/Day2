import java.util.*;

class DesignHashSet {

    int[][] hashset; // 1000 * 1001
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

            // inialization;
            // for loop to make each cell as -1
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
        // nonexisting
        // do nothing here
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