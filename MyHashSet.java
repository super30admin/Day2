
public class MyHashSet {
    private boolean [][] storage;
	private int buckets;
	private int bucketItems;
	/** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        //find spot in array
        int bucket = key % buckets;
        //find spot in 2nd array
        int bucketItem = key / bucketItems;
        //check if a 2nd array is already created
        if(storage[bucket] == null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        //find spot in array
        int bucket = key % buckets;
        //find spot in 2nd array
        int bucketItem = key / bucketItems;
        //check if a 2nd array is already created
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        //find spot in array
        int bucket = key % buckets;
        //find spot in 2nd array
        int bucketItem = key / bucketItems;
        //check if a 2nd array is already created
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketItem];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//edited
