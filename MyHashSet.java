class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;
    

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    private int hashKey1(int key){
        return key %1000;
    }
    
    private int hashKey2(int key){
        return key / 1000;
    }
    public void add(int key) {
        int index1 = hashKey1(key);
        int index2 = hashKey2(key);
        if(storage[index1] == null){
            storage[index1] = new boolean[bucketItems];
        }
        storage[index1][index2] = true;
        
    }
    
    public void remove(int key) {
        int index1 = hashKey1(key);
        int index2 = hashKey2(key);
        if(storage[index1] == null){ 
            return;
        }
        storage[index1][index2] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hashKey1(key);
        int index2 = hashKey2(key);
        if(storage[index1] == null){ 
             return false;
        }
        return storage[index1][index2];
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);
        hashSet.contains(3);    
        hashSet.add(2);
        hashSet.contains(2);
        hashSet.remove(2);
        hashSet.contains(2);

    }
    
}