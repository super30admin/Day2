//Time Complexity - O(1)
//Space Complecity - O(n)
class MyHashSet {
    
    int buckets = 1001;
    int bucketLists = 1001;
    boolean[][] storage = new boolean[buckets][];

    public MyHashSet() {
        
    }
    
    public int bucket(int key) {
        return key % buckets;
    }
    
    public int bucketList(int key) {
        return key / bucketLists;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketList = bucketList(key);
        if(storage[bucket] == null) {
            storage[bucket] = new boolean[bucketLists];
        }
        storage[bucket][bucketList] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketList = bucketList(key);
        if(storage[bucket] != null) {
            storage[bucket][bucketList] = false;
        }
    }
    
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketList = bucketList(key);
        if(storage[bucket] != null) {
            return storage[bucket][bucketList];
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