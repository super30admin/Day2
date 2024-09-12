//Time Complexity
// add:O(1)
//Remove:O(1)
//Contains:O(1)

class MyHashSet {
    int buckets=1000;
    int bucketItems=1000;
    boolean hashSet[][];
    public MyHashSet() {
        hashSet=new boolean[buckets][];
    }
    private int firstHash(int val){
        return val%buckets;
    }
    private int secondHash(int val){
        return val/bucketItems;
    }
    public void add(int key) {
        int bucket=firstHash(key);
        int bucketItem=secondHash(key);
        if(hashSet[bucket]==null){
            if(bucket==0){
                hashSet[bucket]=new boolean[bucketItems+1];
            }else{
                hashSet[bucket]=new boolean[bucketItems];
            }
        }
        hashSet[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
        int bucket=firstHash(key);
        int bucketItem=secondHash(key);
        if(hashSet[bucket]!=null)
            hashSet[bucket][bucketItem]=false;

    }
    
    public boolean contains(int key) {
        int bucket=firstHash(key);
        int bucketItem=secondHash(key);
        if(hashSet[bucket]==null)
            return false;
        return hashSet[bucket][bucketItem];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
