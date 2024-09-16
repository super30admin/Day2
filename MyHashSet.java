/* Time Complexity : O(1)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
*/

class MyHashSet {

    private boolean storage [][];
    int buckets;
    int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    public int bucket(int key){
        return key%buckets;
    }

    public int bucketItem(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
    	int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(storage[bucket] == null) {
            if(bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            }
            else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
    	
    	int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(storage[bucket] == null)
            return;
 
        storage[bucket][bucketItem] = false;
        
    }
    
    public boolean contains(int key) {
    	
    	int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        
        if(storage[bucket] == null) 
        	return false;
        
        return storage[bucket][bucketItem];
        
    }
}

/**
 * Your MyHashSet_List object will be instantiated and called as such:
 * MyHashSet_List obj = new MyHashSet_List();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */