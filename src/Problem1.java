class MyHashSet {
    // Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


    // Your code here along with comments explaining your approach

    boolean[][] buckets;
    public MyHashSet() {
        buckets = new boolean[1001][];
    }

    public void add(int key) {
        int b = getBucket(key);
        int v = getItem(key);
        if(buckets[b] == null){
            buckets[b] = new boolean[1001];
        }

        buckets[b][v]=true;
    }

    public void remove(int key) {
        int b = getBucket(key);
        int v = getItem(key);
        if(buckets[b]==null){
            return;
        }
        buckets[b][v]=false;
    }

    public boolean contains(int key) {
        int b = getBucket(key);
        int v = getItem(key);
        if(buckets[b]==null){
            return false;
        }
        return buckets[b][v];
    }

    public int getBucket(int key){
        return key/1000;
    }

    public int getItem(int key){
        return key%1000;
    }
}