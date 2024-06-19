// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/* Implementing with double hashing technoque */
class MyHashMap {

    int[][]hashMap;
    int primaryArraySize;
    int secondaryArraySize;

    public MyHashMap() {
        primaryArraySize = 1000;
        secondaryArraySize = 1000;
        hashMap = new int[primaryArraySize][];
    }

    public int getPrimaryBucket(int key) {
        return key % primaryArraySize;
    }

    public int getSecondaryArrayBucket(int key) {
        return key / secondaryArraySize;
    }

    public void put(int key, int value) {
        int primaryArrayBucketIndex = getPrimaryBucket(key);
        int secondaryArrayBucketIndex = getSecondaryArrayBucket(key);

        if(hashMap[primaryArrayBucketIndex]== null) {
            if(primaryArrayBucketIndex == 0){
                hashMap[primaryArrayBucketIndex] = new int[secondaryArraySize + 1];
                Arrays.fill(hashMap[primaryArrayBucketIndex], -1);
            }
            else {
                hashMap[primaryArrayBucketIndex] = new int[secondaryArraySize];
                Arrays.fill(hashMap[primaryArrayBucketIndex], -1);
            }
        }
        hashMap[primaryArrayBucketIndex][secondaryArrayBucketIndex] = value;

    }

    public int get(int key) {
        int primaryArrayBucketIndex = getPrimaryBucket(key);
        int secondaryArrayBucketIndex = getSecondaryArrayBucket(key);
        if(hashMap[primaryArrayBucketIndex] == null)
            return -1;
        return hashMap[primaryArrayBucketIndex][secondaryArrayBucketIndex];
    }

    public void remove(int key) {
        int primaryArrayBucketIndex = getPrimaryBucket(key);
        int secondaryArrayBucketIndex = getSecondaryArrayBucket(key);
        if(hashMap[primaryArrayBucketIndex] == null)
            return;
        hashMap[primaryArrayBucketIndex][secondaryArrayBucketIndex] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
