
class MyHashSet {
    private int numBuckets = 15000;
    List<Integer>[] buckets;
    
    private int hash_function(int key){
        return key%numBuckets;
    }
 
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new LinkedList[numBuckets];
    }
    
    public void add(int key) {
        int i=hash_function(key);
        if(buckets[i] == null)
            buckets[i] = new LinkedList<>();
        if(buckets[i].indexOf(key) == -1)
            buckets[i].add(key);
    }
    
    public void remove(int key) {
        int i=hash_function(key);
         if(buckets[i] == null)
            return;
        if(buckets[i].indexOf(key) != -1)
            buckets[i].remove(buckets[i].indexOf(key));
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i=hash_function(key);
        if(buckets[i] == null || buckets[i].indexOf(key) == -1)
            return false;
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */