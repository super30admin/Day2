/*
HashSet using Double Hashing is already done in Design 1 Assignment

Time Complexity: O(1) for put, get, and remove.
Space Complexity: O(1) for operations; O(n) for storage due to the 2D array.
 */
public class HashMapDoubleHashing {

    int primaryArraySize;
    int secondaryArraySize;
    int[][] storage;

    public HashMapDoubleHashing() {
        this.primaryArraySize = 1001;
        this.secondaryArraySize = 1000;
        // Using -1 to indicate an empty slot since key and value are non-negative integers
        this.storage = new int[primaryArraySize][];
    }

    private int getPrimaryHashValue(int key) {
        return key / primaryArraySize;
    }

    private int getSecondaryHashValue(int key) {
        return key % secondaryArraySize;
    }

    public void put(int key, int value) {
        int primaryArrayIndex = getPrimaryHashValue(key);

        if (storage[primaryArrayIndex] == null) {
            // Initialize a new array if it doesn't exist, using -1 as the default value
            this.storage[primaryArrayIndex] = new int[secondaryArraySize];
            for (int i = 0; i < secondaryArraySize; i++) {
                this.storage[primaryArrayIndex][i] = -1;
            }
        }

        int secondaryArrayIndex = getSecondaryHashValue(key);
        storage[primaryArrayIndex][secondaryArrayIndex] = value;
    }

    public int get(int key) {
        int primaryArrayIndex = getPrimaryHashValue(key);

        if (storage[primaryArrayIndex] == null) {
            return -1; // Key doesn't exist
        }

        int secondaryArrayIndex = getSecondaryHashValue(key);
        return storage[primaryArrayIndex][secondaryArrayIndex];
    }

    public void remove(int key) {
        int primaryArrayIndex = getPrimaryHashValue(key);

        if (storage[primaryArrayIndex] == null) {
            return; // Nothing to remove as value doesn't exist
        }

        int secondaryArrayIndex = getSecondaryHashValue(key);
        storage[primaryArrayIndex][secondaryArrayIndex] = -1; // Set to -1 to indicate removal
    }
}
