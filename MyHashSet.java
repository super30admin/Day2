//Time Cost - O(1) for insert get and delete when no rehashing and doubling size is required
class MyHashSet {
    int mainArraySize;
    int secondaryArraySize;
    boolean[][] hashset;
    /** Initialize your data structure here. */
    public MyHashSet() {
        mainArraySize = 1000;
        secondaryArraySize = 1000;
        hashset = new boolean[mainArraySize][];
    }
    
    public int hashFun(int key) {
        int index = key % mainArraySize;
        return index;
    }
    
    public int supportHashFun(int key) {
        int index = key / secondaryArraySize;
        return index;
    }
    
    public void add(int key) {
        if(!contains(key))
        {
            int mainIndex = hashFun(key);
            int subIndex = supportHashFun(key);
            if(hashset[mainIndex] == null)
            {
                hashset[mainIndex] = new boolean[secondaryArraySize];
            }
            hashset[mainIndex][subIndex] = true;
        }
    }
    
    public void remove(int key) {
        int mainIndex = hashFun(key);
        int subIndex = supportHashFun(key);
        if(hashset[mainIndex] != null)
        {
            hashset[mainIndex][subIndex] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int mainIndex = hashFun(key);
        int subIndex = supportHashFun(key);
        if(hashset[mainIndex] != null)
        {
            return hashset[mainIndex][subIndex];
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
