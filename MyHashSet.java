Time complexity: o(1)

Space complexity:O(n)

class MyHashSet {

    /** Initialize your data structure here. */
    boolean [][] storage;
        int buckets ;
        int bucketItems ;
    
    public MyHashSet() {
         buckets = 1000;
        bucketItems = 1001;
        storage = new boolean[buckets][];
    }
    
     public int bucket(int value){ 

       return value%buckets;

   }

   public int bucketItem(int value){ 

       return value/buckets;

   }
    
    public void add(int key) {
       int bucket = bucket(key);      

       int bucketItem = bucketItem(key);

       if(storage[bucket] == null){

           storage[bucket] = new boolean[bucketItems]; 

       }

       storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);

        int bucketItem = bucketItem(key);

       if(storage[bucket] != null){

           storage[bucket][bucketItem] = false;

       }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);

       int bucketItem = bucketItem(key);

       return storage[bucket] != null && storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */