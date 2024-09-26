public class MyHashSet {
	/**Double hashing| Time O(1) | Space O(n)**/
	private boolean[][] storage;
    private int buckets;
    private int bucketItems;
    
    public MyHashSet() {
        this.buckets=1000;
        this.bucketItems=1000;
        this.storage= new boolean[buckets][];
    }
    
    private int bucket(int key){
        return key%buckets;
    }
    private int bucketItem(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket= bucket(key);
        int bucketItem= bucketItem(key);
        if(storage[bucket] == null) {
        	if(bucket == 0) {
	        	storage[bucket]= new boolean[bucketItems+1]; //First bucket
	        }else {
	        	storage[bucket]= new boolean[bucketItems];
	        }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
    	int bucket= bucket(key);
        int bucketItem= bucketItem(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
    	int bucket= bucket(key);
        int bucketItem= bucketItem(key);
        if(storage[bucket] == null) return false;
        return storage[bucket][bucketItem];
    }
	
	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.contains(1); // returns true
		hashSet.contains(3); // returns false (not found)
		hashSet.add(2);
		hashSet.contains(2); // returns true
		hashSet.remove(2);
		hashSet.contains(2); // returns false (already removed)
	}	
}
