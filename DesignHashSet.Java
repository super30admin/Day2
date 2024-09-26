class MyHashSet{
 boolean [][] storage;
 int buckets;
 int bucketItems;
 public HastSet(){
     buckets = 1000;
     bucketItems= 1000;
     storage = new boolean[buckets][];
 }
 public int getBuckets(int key){
     return key % buckets;
 }

 public int getBucketItems(int key){
     return key / bucketItems;
 }
 public  void add(int key){
     int bucket = getBucket(key);
     int bucketItems = getBuckets(key);
     if(storage[bucket] == null){
         if(bucket == 0 ){
             stoarge[bucket] = new boolean[bucketItems+1];
         }
         else {
             storage[bucket] = new boolean[bucketItems];
         }
     }
     storage[bucket][bucketItems] = true;
 }

 public void remove(int key){
     int bucket = getBucket(key);
     int bucketItems = getBuckets(key);
     if(stoarge[bucket] == null){
         return
     }
    storage[bucket][bucketItems] = false;
 }

 public boolean contains (int key){
     int bucket = getBucket(key);
     int bucketItems = getBuckets(key);
     if(stoarge[bucket] == null){
         return false;
     }
     return storage[bucket][bucketItems];
 }

}