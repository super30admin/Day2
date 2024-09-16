// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    
  int bucket;
  int bucketItems;

  // Having a boolean map to reduce space
  boolean map[][];
  
  public MyHashSet() {
      bucket = 1000;
      bucketItems = 1000;
      map = new boolean[bucket][];
  }
  
  // Hashing function 1
  private int getBucket(int key) {
      return key % bucket;
  }
  
  // Hashing function 2
  private int getBucketItem(int key) {
      return key / bucketItems;
  }
  
  public void add(int key) {
      int i = getBucket(key), j = getBucketItem(key);
      
      if (map[i] == null)
          if (i == 0) // If 10^6 edge case condition
              map[i] = new boolean[bucketItems + 1];
          else
              map[i] = new boolean[bucketItems];
      
      map[i][j] = true;
  }
  
  public void remove(int key) {
      int i = getBucket(key), j = getBucketItem(key);
      
      if (map[i] == null)
          return;
      
      map[i][j] = false;
  }
  
  public boolean contains(int key) {
      // If map isn't initialized
      if (map[getBucket(key)] == null)
          return false;
      return map[getBucket(key)][getBucketItem(key)];        
  }
}

/**
* Your MyHashSet object will be instantiated and called as such:
* MyHashSet obj = new MyHashSet();
* obj.add(key);
* obj.remove(key);
* boolean param_3 = obj.contains(key);
*/