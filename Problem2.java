public class MyHashSet {

	Integer[][] hashsetStorage;
	int numberOfBuckets;
	int numberOfBucketItems;
	
	public MyHashSet() {
		numberOfBuckets = 1001;
		numberOfBucketItems = 1000;
		hashsetStorage = new Integer[numberOfBuckets][numberOfBucketItems];
	}
	
	public void add(int key) {
		int bucketNumber = key % numberOfBuckets;
		int bucketItemNumber = key % numberOfBucketItems;
		
		hashsetStorage[bucketNumber][bucketItemNumber] = key;
	}
	
	public void remove(int key) {
		int bucketNumber = key % numberOfBuckets;
		int bucketItemNumber = key % numberOfBucketItems;
		
		if(hashsetStorage[bucketNumber][bucketItemNumber] != null) {
			hashsetStorage[bucketNumber][bucketItemNumber] = null;
		}
	}
	
	public boolean contains(int key) {
		int bucketNumber = key % numberOfBuckets;
		int bucketItemNumber = key % numberOfBucketItems;
		
		if(hashsetStorage[bucketNumber][bucketItemNumber] == null) {
			return false;
		}
		return true;
	}
}
