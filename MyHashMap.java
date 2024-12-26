// Time Complexity: O(1) put, get, remove
// Space complexity: O(bucketCount×bucketItemCount)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Arrays;

class MyHashMap {
    int[][] bucket;
    int bucketCount;
    int bucketItemCount;

    public MyHashMap() {
        this.bucketCount = 1000;
        this.bucketItemCount = 1000;
        this.bucket = new int[this.bucketCount][];
    }

    public int getBucket(int key) {
        return key % this.bucketCount;
    }

    public int getBucketItem(int key) {
        return key / this.bucketCount;
    }

    public void put(int key, int value) {
        int bucketIndex = getBucket(key);
        int bucketItemIndex = getBucketItem(key);
        if(this.bucket[bucketIndex] == null) {
            this.bucket[bucketIndex] = (bucketIndex == 0) ? new int[this.bucketCount + 1] : new int[this.bucketCount];
            Arrays.fill(this.bucket[bucketIndex], -1);
        }

        this.bucket[bucketIndex][bucketItemIndex] = value;
    }

    public int get(int key) {
        int bucketIndex = getBucket(key);
        int bucketItemIndex = getBucketItem(key);
        if(this.bucket[bucketIndex] == null || this.bucket[bucketIndex][bucketItemIndex] == -1) {
            return -1;
        }

        return this.bucket[bucketIndex][bucketItemIndex];
    }

    public void remove(int key) {
        int bucketIndex = getBucket(key);
        int bucketItemIndex = getBucketItem(key);
        if(this.bucket[bucketIndex] != null) {
            this.bucket[bucketIndex][bucketItemIndex] = -1;
        }
    }
}