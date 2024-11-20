// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
  int buckets = 1000;
  int bucketItems = 1000;
  boolean [][] storage = new boolean[buckets][];
  
  public MyHashSet() {}
  private int bucket(int key) {
     return key%buckets;
  }
  
  private int bucketItem(int key){
     return key/buckets;
  }
 
 public void add(int key) {
   int bucket = bucket(key);
   int bucketItem = bucketItem( key);
   if(storage[bucket] == null) {
      storage[bucket]  = new boolean[buckets] ;
   } 
 	storage[bucket][bucketItem] = true;	
 }
 
  
  public void remove(int key) {
    int bucket = bucket(key);
    int bucketItem = bucketItem( key);
    if(storage[bucket] != null) {
      storage[bucket][bucketItem] = false;
    } 
  }

 public boolean contains(int key) {
    int bucket = bucket(key);
    int bucketItem = bucketItem( key);
    if(storage[bucket] != null) {
      return storage[bucket][bucketItem] == true;
    } else{
      return false;
    }
  }


}
