/* Leetcode Question 705 */
public class MyHashSet {
    /** Initialize your data structure here. */
    int Bucket; //to calcute the bucket number
    int BucketItems; // to calculate the index of the item number in a given bucket
    boolean[][] storage;
    public MyHashSet() {
        Bucket = 1000;
        BucketItems = 1001;
        storage = new boolean[Bucket][];
    }
    private int Bucket(int key){
        return key % Bucket;
    } 
    private int BucketItems(int key){
        return key / BucketItems;
    }
    
    public void add(int key) {
        int bucket = Bucket(key);
        int bucketitem = BucketItems(key);
        System.out.println(bucket);
        System.out.println(bucketitem);
        if(storage[bucket] == null){
            storage[bucket] = new boolean[BucketItems];
        }
        storage[bucket][bucketitem] = true;
    }
    
    public void remove(int key) {
        int bucket = Bucket(key);
        int bucketitem = BucketItems(key);
        if(!contains(key)){
            return;
        }
        storage[bucket][bucketitem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = Bucket(key);
        int bucketitem = BucketItems(key);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketitem];
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boole