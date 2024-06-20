// Time Complexity :
// put - O(1)
// get - O(1)
// remove - O(1)
// Space Complexity : O(N) where N is the range of input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class DesignHashMapDoubleHashing {
    int[][] storage;
    int baseArraySize;
    int subArraySize;

    public DesignHashMapDoubleHashing() {
        this.baseArraySize = 1000;
        this.subArraySize = 1001;
        // Declare base array only. Sub arrays can be defined once a number belonging to that some array is added
        // thus, Uses storage space efficiently
        this.storage = new int[baseArraySize][];
    }

    public int getHashKeyBase(int key) {
        return key%baseArraySize;
    }

    public int getHashKeySub(int key) {
        return key/subArraySize;
    }

    public void put(int key, int value) {
        int baseArrayIndex = getHashKeyBase(key);
        int subArrayIndex = getHashKeySub(key);

        // If base storage array is null, the subarray and number both wont exist. Hence
        // define subarray of required size first and initialize to -1
        if (storage[baseArrayIndex] == null) {
            storage[baseArrayIndex] = new int[subArraySize];
            Arrays.fill(storage[baseArrayIndex], -1);
        }
        // put value in subarray at computed position for number, indicating the number is added in appropriate position
        storage[baseArrayIndex][subArrayIndex] = value;
    }

    public int get(int key) {
        int baseArrayIndex = getHashKeyBase(key);
        int subArrayIndex = getHashKeySub(key);

        // If base storage array is null, the subarray is not present, hence, the number does not exist. So return -1
        if (storage[baseArrayIndex] == null) {
            return -1;
        }

        return storage[baseArrayIndex][subArrayIndex];
    }

    public void remove(int key) {
        int baseArrayIndex = getHashKeyBase(key);
        int subArrayIndex = getHashKeySub(key);

        // If base storage array is null, the subarray is not present, hence, the number does not exist. So return
        if (storage[baseArrayIndex] == null) {
            return;
        }
        // else remove whats stored at subarray at computed position for the key. If present, mark it -1, else do nothing.
        storage[baseArrayIndex][subArrayIndex] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * DesignHashMapDoubleHashing obj = new DesignHashMapDoubleHashing();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */