// Time Complexity : 10^6--> O(1) ---> if n--> O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {
    private boolean[][] storageArr; 
    private int buckets;//hash1 
    private int bucketItems;//hash2
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storageArr = new boolean[buckets][];
    }
    
    //first hashfunction
    private int bucket(int key){
        return key%buckets;
    }
    
    //second hashfunction
    private int bucketItems(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItems(key);
        
        // if 10^6 is the number then key is 
        if(bucket==0){
            storageArr[bucket] = new boolean[bucketItems+1];
        }else{
            storageArr[bucket] = new boolean[bucketItems];   
        }
        storageArr[bucket][bucketItems] = true;
    }
    
    public void remove(int key) {
        int bucket  = bucket(key);
        int bucketItem = bucketItems(key);
        if(storageArr[bucket]==null) return;
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket  = bucket(key);
        int bucketItem = bucketItems(key);
        if(storageArr[bucket]==null) return false;
        return storage[bucket][bucketItem];
    }

    public static void main(String args[]) 
    {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);         
        hashSet.add(2);         
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);          
        hashSet.contains(2);    // returns true
        hashSet.remove(2);          
        hashSet.contains(2);    // returns false (already removed)
        }
}