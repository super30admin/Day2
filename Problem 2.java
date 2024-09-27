class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketsize;
   /** Initialize your data structure here. */
   public MyHashSet() {
   storage = new boolean[1000][];
   buckets = 1000;
   bucketsize = 1000;
       
   }
   
   private int getbucketIndex(int key){
      return key % 1000;
   }
   
   private int getbucketitemIndex(int key){
       return key / 1000;
   }
   
   public void add(int key) {
       int bucketIndex = getbucketIndex(key);
       int bucketItemIndex = getbucketitemIndex(key);
       if(storage[bucketIndex] == null){
           if(bucketIndex == 0){
               storage[bucketIndex] = new boolean[bucketsize + 1];               
           }
           else{
           storage[bucketIndex] = new boolean[bucketsize]; 
           }
       }
       storage[bucketIndex][bucketItemIndex] = true;
   }
   
   
   public void remove(int key) {
       int bucketIndex = getbucketIndex(key);
       int bucketItemIndex = getbucketitemIndex(key);
       if(storage[bucketIndex] == null)
           return;
       storage[bucketIndex][bucketItemIndex] = false;
           
       }
   
   
   /** Returns true if this set contains the specified element */
   public boolean contains(int key) {
       int bucketIndex = getbucketIndex(key);
       int bucketItemIndex = getbucketitemIndex(key);
       if(storage[bucketIndex] == null)
            return false;
       return storage[bucketIndex][bucketItemIndex];
   }
}

/**
* Your MyHashSet object will be instantiated and called as such:
* MyHashSet obj = new MyHashSet();
* obj.add(key);
* obj.remove(key);
* boolean param_3 = obj.contains(key);
*/