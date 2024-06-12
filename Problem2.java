class MyHashSet{
    private boolean[][] storage;
    private final int BUCKETS;
    private final int BUCKET_ITEMS;

    public MyHashSet(){
        BUCKETS = 1000;
        BUCKET_ITEMS = 1000;
        this.storage = new boolean[BUCKETS][];
    }

    // first hash function
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    private int bucketHash(int key){
        return key % BUCKETS;
    }

    // second hash function
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    private int bucketItemsHash(int key){
        return key / BUCKET_ITEMS;
    }
    
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    public void add(int key){
        int bucket = bucketHash(key);
        int bucketItem = bucketItemsHash(key);
        if(storage[bucket] == null){
            if(bucket == 0) 
                storage[bucket] = new boolean[BUCKET_ITEMS + 1];
            else
                storage[bucket] = new boolean[BUCKET_ITEMS];
        }
        storage[bucket][bucketItem] = true;
    }
    
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    public boolean contains(int key){
        int bucket = bucketHash(key);
        int bucketItem = bucketItemsHash(key);
        if(storage[bucket] == null) return false;
        return storage[bucket][bucketItem];
    }
    
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    public void remove(int key){
        int bucket = bucketHash(key);
        int bucketItem = bucketItemsHash(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(22);
        obj.remove(22);
        boolean param_3 = obj.contains(22);
        System.out.println(param_3);
    }
}
