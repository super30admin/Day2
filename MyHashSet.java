class MyHashSet {
    
    boolean[][] storage;
    int buckets = 1000;
    int bucketSlots = 1000;

    /** Initialize your data structure here. */
    public MyHashSet() {
        storage = new boolean[buckets][];
    }
    
    public void add(int key) {
        int hashcode1 = hashFunc1(key);
        if(storage[hashcode1] == null) {
            storage[hashcode1] = new boolean[bucketSlots];
        }
        int hashcode2 = hashFunc2(key);
        storage[hashcode1][hashcode2] = true;
        
    }
    
    public void remove(int key) {
        int hashcode1 = hashFunc1(key);
        int hashcode2 = hashFunc2(key);
        if(storage[hashcode1] != null) {
            storage[hashcode1][hashcode2] = false;
        } 
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashcode1 = hashFunc1(key);
        int hashcode2 = hashFunc2(key);
        return storage[hashcode1] != null && storage[hashcode1][hashcode2] == true;
    }
    
    public int hashFunc1(int key) {
        return key%buckets;
    }
    
    public int hashFunc2(int key) {
        return key/bucketSlots;
    }
    
    public static void main(String[] args) {
    	MyHashSet hashSet = new MyHashSet();
    	boolean result;
    	hashSet.add(1);         
    	hashSet.add(2);         
    	result = hashSet.contains(1);    // returns true
    	System.out.println(result);
    	result = hashSet.contains(3);    // returns false (not found)
    	System.out.println(result);
    	hashSet.add(2);          
    	result = hashSet.contains(2);    // returns true
    	System.out.println(result);
    	hashSet.remove(2);          
    	result = hashSet.contains(2);    // returns false (already removed)
    	System.out.println(result);
    }
}

