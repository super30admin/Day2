// Time Complexity : O(1) for all operations
// Space Complexity : O(N) in worst case. Where N = 10^6.
// Did this code successfully run on Leetcode : YES
// LC submission link: https://leetcode.com/submissions/detail/526176162/
// Any problem you faced while coding this : No issues

class MyHashSet {

    private int totalPositionsInBuckets;
    private int totalBuckets;
    private boolean[][] hashSet;

    /** Initialize your data structure here. */
    public MyHashSet() {
        totalBuckets = totalPositionsInBuckets = 1000;
        hashSet = new boolean[totalBuckets][];
    }

    //This method helps in finding the bucket no for a particular key
    private int findBucket(int key) {
        return key%totalBuckets;
    }

    //this method helps find the position in a particular bucket
    private int findPositionInBucket(int key) {
        return key/totalPositionsInBuckets;
    }

    public void add(int key) {
        int bucket = findBucket(key);
        int positionInBucket = findPositionInBucket(key);

        if(null == hashSet[bucket]){
            if (0 == bucket) {
                hashSet[bucket] = new boolean[totalPositionsInBuckets+1];
            } else {
                hashSet[bucket] = new boolean[totalPositionsInBuckets];
            }
        }
        hashSet[bucket][positionInBucket] = true;
    }

    public void remove(int key) {
        if(this.contains(key)) {
            int bucketIndex = findBucket(key);
            int positionInBucket = findPositionInBucket(key);

            hashSet[bucketIndex][positionInBucket] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = findBucket(key);
        int positionInBucket = findPositionInBucket(key);

        if (null == hashSet[bucketIndex] || false == hashSet[bucketIndex][positionInBucket] ) {
            return false;
        }

        return true;
    }
}
