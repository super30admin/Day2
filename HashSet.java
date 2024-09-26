// Time Complexity :
//      add = O(1)
//      remove = O(1)
//      contains = O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes

class MyHashSet {

    private boolean [][] storage;
    private int buckets;
    private int bucketitems;
    
    
   public MyHashSet() {
       buckets = 1000;
       bucketitems = 1000;
       storage = new boolean[buckets][];
    }
    
     private int bucket(int key) {
        return key % buckets;
    }
    
     private int bucketItem(int key) {
        return key / bucketitems;
    }
    
    public void add(int key) {
        int bucketIndex = bucket(key);
        int bucketItemIndex =  bucketItem(key);
        if(storage[bucketIndex] == null) {
            if(bucketIndex == 0) {
                storage[bucketIndex] = new boolean[bucketitems + 1];
            } else {
                storage[bucketIndex] =  new boolean[bucketitems];  
            }
        }
       storage[bucketIndex][bucketItemIndex] = true;
        
    }

    
    public void remove(int key) {
        int bucketIndex = bucket(key);
        int bucketItemIndex =  bucketItem(key);
        if(storage[bucketIndex] == null) {
            return;
        }
        storage[bucketIndex][bucketItemIndex] = false;
        
    }
    
    public boolean contains(int key) {
        int bucketIndex = bucket(key);
        int bucketItemIndex =  bucketItem(key);
        if(storage[bucketIndex] == null) {
            return false;
        }
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