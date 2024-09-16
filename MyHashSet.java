// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MyHashSet {
	
	int firstBuckets = 1000;
    int secondBuckets = 1000;
    boolean[][] bucket = new boolean[firstBuckets][];
    
    public int firstBucket(int key){
        return Integer.hashCode(key%firstBuckets); 	//hashing for first bucket using modulo operation
    }
    
    public int secondBucket(int key){
        return Integer.hashCode(key/secondBuckets);  //hashing for second bucket using divide operation
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int firstBucket = firstBucket(key);
        int secondBucket = secondBucket(key);
        // if first bucket is null, then initialize second, add values to bucket and make it true(1).
        if(bucket[firstBucket] == null)
        	bucket[firstBucket] = new boolean[secondBuckets];
        
        bucket[firstBucket][secondBucket] = true;    
    }
    
    public void remove(int key) {
        int firstBucket = firstBucket(key);
        int secondBucket = secondBucket(key);
        // if first bucket is not null, then make it false(0) to remove.
        if(bucket[firstBucket] != null)
        	bucket[firstBucket][secondBucket] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int firstBucket = firstBucket(key);
        int secondBucket = secondBucket(key);
        return bucket[firstBucket] != null && bucket[firstBucket][secondBucket];
    }

	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		System.out.println("returns "+hashSet.contains(1));
		System.out.println("returns "+hashSet.contains(3));
		hashSet.add(2);          
		System.out.println("returns "+hashSet.contains(2));
		hashSet.remove(2);          
		System.out.println("returns "+hashSet.contains(2));
	}
}
