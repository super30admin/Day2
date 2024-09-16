// Time Complexity - O(1) for all operations
// Works on LeetCode

class MyHashSet {

    private int bucket = 10000;
    private int bucketItem = 10000;
    private boolean[][] hashset;
    
    private int hashfunc1(int key){
        return key % bucket;
    }
    
    private int hashfunc2(int key){
        return key / bucketItem;
    }
    
    public MyHashSet() {
        hashset = new boolean[bucket][];
    }
    
    public void add(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);
        
        if(hashset[index1]==null){
            hashset[index1] = new boolean[bucketItem];
        }
        hashset[index1][index2] = true;
    }
    
    public void remove(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);
        
        if(hashset[index1]!=null){
            hashset[index1][index2]=false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1 = hashfunc1(key);
        int index2 = hashfunc2(key);
        
        if(hashset[index1]!=null){
            return hashset[index1][index2];
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
