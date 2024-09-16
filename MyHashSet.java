// Time Complexity : O(1) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach


class MyHashSet {

    /** Initialize your data structure here. */
    private boolean[] [] storage;
    private int buckets;
    private int bucketItems;
    public MyHashSet() {
        buckets=1000;
        bucketItems=1001;
        storage=new boolean[buckets][];
    }
    
    private int bucket(int key){
        return key%buckets;
    }
    
    private int bucketItem(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null){
            storage[bucket]=new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
        System.out.println("key is added");
        
    }
    
    public void remove(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem]=false;
        System.out.println("key is removed");
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null) return false;
        return storage[bucket][bucketItem];
    }


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

public static void main(String args[]) 
{ 
    MyHashSet obj = new MyHashSet();
    obj.add(10);
    obj.remove(10);
    boolean param_3 = obj.contains(10);
    System.out.println(param_3);
} 
} 