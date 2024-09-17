//TC: O(1) and will not be taking TC of constructor bcz its one time activity and its not user focused 
//using double hashing
//primary arr needs to store nulls as the pointers and secondary arr initiated as boolean will be zero by default 
class MyHashSet {
    
    private boolean [][] storage;
    int buckets;
    int bucketItems;

   
   public int bucket(int value){ 
       return value%buckets;
   }

   public int bucketItem(int value){ 
       return value/buckets;
   }

   /** Initialize your data structure here. */

   public MyHashSet() {
       this.buckets = 1000;
       this.bucketItems = 1000;
       this.storage = new boolean[buckets][];

   }

   public void add(int value ) {

       int bucket = bucket(value);      
       int bucketItem = bucketItem(value);
       
       if(storage[bucket] == null){
           if(bucket == 0) {
               //edge case to handle last element as 1000000/1000=0, we need extra space at the end
                storage[bucket] = new boolean[bucketItems + 1]; 
           } else {
                storage[bucket] = new boolean[bucketItems];
           }
          
       }
       storage[bucket][bucketItem] = true;

   }

   public void remove(int value) {

        int bucket = bucket(value);
        int bucketItem = bucketItem(value);

       if(storage[bucket] != null){
           storage[bucket][bucketItem] = false;
       }

   }

   /** Returns true if this set contains the specified element */

   public boolean contains(int value) {
       
       int bucket = bucket(value);
       int bucketItem = bucketItem(value);
       return storage[bucket] != null && storage[bucket][bucketItem];

   }

}