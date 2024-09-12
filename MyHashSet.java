/**
 * Time Complexity : O(1)
 * Space Complexity: O(n)
 * Approach used : double buckets
 */

public class MyHashSet {
    boolean [][] store;
    int buckets, bucketItems;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1001;
        store = new boolean[buckets][];
    }
    
    private int getBkt(int key){
        return key%buckets;
    }
    
    private int getBktItms(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket = getBkt(key);
        int bucketItem = getBktItms(key);
        if(store[bucket]==null){
            store[bucket] = new boolean[bucketItems];
        }
        store[bucket][bucketItem]=true;    
        }
    
    public void remove(int key) {
        int bucket = getBkt(key);
        int bucketItem = getBktItms(key);
        if(store[bucket]!=null)
            store[bucket][bucketItem] = false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBkt(key);
        int bucketItem = getBktItms(key);
        if(store[bucket]!=null)
            return store[bucket][bucketItem];
        return false; 
    }


public static void main(String args[]) {
    MyHashSet obj = new MyHashSet();
    int key=10;
    obj.add(key);
    obj.remove(key);
    boolean param_3 = obj.contains(key);
    System.out.println(param_3);
}

}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */