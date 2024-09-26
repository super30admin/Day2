// Time Complexity : Add(), Remove(), contains() take O(1) time complexity
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {

    // Using double hash technique to create custom hash set
    private boolean [][] hash;
    private int buckets = 1000;

    // taking boolean 2D matrix, true indicate element is present, otherwise false.
    public MyHashSet() {
        hash = new boolean[buckets][];
    }

    public void add(int key) {
        // get the correct bucket value for the given key
        int bucket = this.getBucketNo(key);

        // if this bucket is accessed for the first time
        if (hash[bucket] == null) {

            if (bucket == 0) {
                // this is an edge case when key = 1000000, bucket here would be 0 and for 0th bucket chain list position would be 1000. Since generally we would need only 1000 at most in other buckets excepts for 0th.
                hash[bucket] = new boolean[buckets + 1];
            } else {
                hash[bucket] = new boolean[buckets];
            }
        }
        hash[bucket][this.getChainNo(key)] = true;

    }

    private int getBucketNo(int key) {
        // determines the correct bucket for this key i.e. correct row number
        return key % buckets;
    }

    private int getChainNo(int key) {
        // determines the correct position inside a bucket for this key i.e. correct column number
        return key / buckets;
    }

    // identifies the correct bucket and correct chain list position inside that bucket and marks it as false
    public void remove(int key) {
        int bucket = this.getBucketNo(key);
        if (hash[bucket] != null) {
            hash[bucket][this.getChainNo(key)] = false;
        }
    }

    // identifies the correct bucket and correct chain list position inside that bucket and checks if its available
    public boolean contains(int key) {
        int bucket = this.getBucketNo(key);
        if (hash[bucket] != null) {
            return hash[bucket][this.getChainNo(key)];
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */