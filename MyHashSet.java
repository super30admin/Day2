// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashSet {
        private boolean[][] storage;
        private int bucket;
        private int bucketItem;

   public MyHashSet() {
        bucket = 1000;
        bucketItem = 1000;
        storage = new boolean[bucket][];
        
        
        
    }
    public int Kbucket(int key){
        return key % 1000;
    }
    public int KbucketItem(int key){
        return key/1000;
    }
    
    public void add(int key) {
        int key1 = Kbucket(key);
        int key2 = KbucketItem(key);
        if(storage[key1] == null){
            if(key1 == 0){
                storage[key1] = new boolean[bucketItem + 1];
            } else{
                storage[key1] = new boolean[bucketItem];
            }
        }
        storage[key1][key2] = true;
        
        
        
    }
    
    public void remove(int key) {
        int key1 = Kbucket(key);
        int key2 = KbucketItem(key);
        if(storage[key1] == null){
            return;
        } else{
            storage[key1][key2] = false;
        }
    }
    
  public boolean contains(int key) {
        int key1 = Kbucket(key);
        int key2 = KbucketItem(key);
        if(storage[key1] == null){
            return false;
        } else if(storage[key1][key2] == true){
            return true;
            
        }else if(storage[key1][key2] == false){
            return false;
        }
      return true;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */