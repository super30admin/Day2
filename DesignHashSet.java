// Time Complexity : O(1) for all operations 
// Space Complexity : O(n) (where n is size of the array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A
class MyHashSet {
    
    private boolean storage[][];
    private int primarySize;
    private int secondarySize;

    public MyHashSet() {
        this.primarySize = 1000;
        this.secondarySize = 1000;
        this.storage = new boolean[primarySize][]; //not initializing size for secondary array as its size will change for the zeroth index of primary array
    }
    
    //creating hash functions to calculate primary and secondary bucket indices
    public int primaryHash(int key)
    {
        return key%primarySize;
    }
    
    public int secondaryHash(int key)
    {
        return key/secondarySize;
    }
    
    public void add(int key) {
        int primaryIndex = primaryHash(key);
        int secondaryIndex = secondaryHash(key);
        if(storage[primaryIndex]==null) //
        {
            if(primaryIndex==0)
                this.storage[primaryIndex] = new boolean[secondarySize+1]; //In case of key 1000000, secondary index will be 1000, hence size+1 will help with stack overflow
            else
                this.storage[primaryIndex] = new boolean[secondarySize];
        }
        storage[primaryIndex][secondaryIndex] = true;
        
    }
    
    public void remove(int key) {
        int primaryIndex = primaryHash(key);
        int secondaryIndex = secondaryHash(key);
        if(storage[primaryIndex]==null) return; //no point in checking further when it's null
        storage[primaryIndex][secondaryIndex] = false;
        
    }
    
    public boolean contains(int key) {
        int primaryIndex = primaryHash(key);
        int secondaryIndex = secondaryHash(key);
        if(storage[primaryIndex]==null)
            return false; 
        return storage[primaryIndex][secondaryIndex]; //if key is present it will return true else will return false
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */