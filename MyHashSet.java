class MyHashSet {

    /** Initialize your data structure here. */
    boolean[][] buckets;
    int bucketSize = 1000;
    public MyHashSet() {
        buckets = new boolean[bucketSize][];
    }

    public void add(int key) {
        int idx = key % 1000;
        int nestedIdx = key / 1000;
        if(buckets[idx] == null){
            if(idx == 0){
                buckets[idx] = new boolean[bucketSize + 1];
            }
            else{
                buckets[idx] = new boolean[bucketSize];
            }

        }
        buckets[idx][nestedIdx] = true;
    }

    public void remove(int key) {
        int idx = key % 1000;
        int nestedIdx = key / 1000;
        if(buckets[idx] == null){
            return;
        }
        buckets[idx][nestedIdx] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = key % 1000;
        int nestedIdx = key / 1000;
        if(buckets[idx] == null){
            return false;
        }
        return buckets[idx][nestedIdx];
    }
}