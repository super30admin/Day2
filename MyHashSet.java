package Design2;

public class MyHashSet {
	 boolean[][] storage;
	    //primary array
	    int Buckets;
	    //no of the secondary array.
	    int BucketItems;

	    /** Initialize your data structure here. */
	    public MyHashSet() {
	       Buckets = 1000;
	        BucketItems = 1000;
	        storage = new boolean[Buckets][];
	        
	    }
	    
	    public void add(int key) {
	      int bucket =  key % Buckets;
	      int bucketItem =  key / BucketItems;
	        if(storage[bucket] == null){
	            if(bucket == 0){
	                storage[bucket] = new boolean[BucketItems+1];
	            }
	            else{
	                 storage[bucket] = new boolean[BucketItems];
	            }
	            
	        }
	        storage[bucket][bucketItem]=true;
	    }
	    
	    public void remove(int key) {
	         int bucket =  key % Buckets;
	      int bucketItem =  key / BucketItems;
	        if(storage[bucket]==null){
	            return;
	        }
	         storage[bucket][bucketItem]=false;
	    }
	    
	    /** Returns true if this set contains the specified element */
	    public boolean contains(int key) {
	         int bucket =  key % Buckets;
	      int bucketItem =  key / BucketItems;
	        if(storage[bucket]==null){
	            return false;
	        }
	        return storage[bucket][bucketItem];
	    }

}
