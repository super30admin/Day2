class DesignHashSet {
    boolean[][] buckets;
    boolean[] bucketItems;
    public DesignHashSet() {
        buckets= new boolean[1000][];
        bucketItems= new boolean[1000];
    }

    private int getBucket(int key){
        return key % 1000;
    }

    private int getBucketItem(int key){
        return key / 1000;
    }

    public void add(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(buckets[bucket]==null){
            if(bucket==0) buckets[bucket]=new boolean[1000+1];
            else buckets[bucket]=new boolean[1000];
        }
        bucketItems=buckets[bucket];
        if(bucketItems[bucketItem]) return;
        bucketItems[bucketItem]=true;
    }

    public void remove(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(buckets[bucket]==null){
            return;
        }
        bucketItems=buckets[bucket];
        if(!bucketItems[bucketItem]) return;
        bucketItems[bucketItem]=false;
    }

    public boolean contains(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(buckets[bucket]==null){
            return false;
        }
        bucketItems=buckets[bucket];
        if(bucketItems[bucketItem]) return true;
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