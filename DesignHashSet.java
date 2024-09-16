//time complexity : O(1)
//space complexity: O(n) where n is size of each array
//implemented on leetcode: yes
// issues: still confused why we use buckets instead of bucketItems in public int bucketItems(int key).



class MyHashSet {
    int buckets = 1000;
    int bucketItems = 1000;
    boolean[][] storage = new boolean[buckets][];  // we will initialize another array(2nd dimension) only when we need to store a value in the array when storage[bucket] is null.
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    public int bucket(int key)
    {
        return key%buckets;
    }
    public int bucketItems(int key)
    {
        return key/buckets;
    }
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(storage[bucket]==null)
        {
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        if(storage[bucket]!=null)
        {
            storage[bucket][bucketItem] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        return storage[bucket]!=null && storage[bucket][bucketItem]!=false;
        
    }
    public static void main(String[] args)
    {
        MyHashSet obj = new MyHashSet();
        obj.add(1002);
        obj.remove(1002);
        boolean param_3 = obj.contains(1002);
        System.out.println(param_3);
    }
}
