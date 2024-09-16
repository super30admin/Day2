import java.util.HashMap;

public class HashSet1 {


    int buckets;
    int bucketItems;
    boolean[][] hashset;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001; //to avoid runtime exception
        //we do not update bucket items yet to save space
        hashset = new boolean[buckets][]; 
    }
    private int bucket(int key){
        return key % buckets;
    }

    private int bucketItem(int key){
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if(hashset[bucket] == null){
            hashset[bucket] = new boolean[bucketItems];
        }
        hashset[bucket][bucketItem] = true;

    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if(hashset[bucket] == null){
            return;
        }
        hashset[bucket][bucketItem] = false;

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if(hashset[bucket] == null){
            return false;
        }
        return hashset[bucket][bucketItem];
    }
}
