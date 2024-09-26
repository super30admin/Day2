//Time complexity-O(1)
//Space complexit-O(1)->bucket size is constant depending on the range of keys
//Followed shaz's method

class MyHashSet {

    /** Initialize your data structure here. */
    private int bucket=1000;
    private int bucketItem=1000;
    
    
    public boolean Hashset[][];
    public MyHashSet() {
        Hashset=new boolean[bucket][];
    }
    
    private int hashfunc1(int key)
    {
        return key%bucket;
    }
    private int hashfunc2(int key)
    {
        return key / bucketItem;
    }
    
    public void add(int key) {
        int index1=hashfunc1(key);
        int index2=hashfunc2(key);
        
        if(Hashset[index1]==null)
        {
            Hashset[index1]=new boolean[bucketItem];
        }
        Hashset[index1][index2]=true;
        
    }
    
    public void remove(int key) {
        int index1=hashfunc1(key);
        int index2=hashfunc2(key);
        
        if(Hashset[index1]==null)
        {
        return;
        }
        Hashset[index1][index2]=false;
        
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index1=hashfunc1(key);
        int index2=hashfunc2(key);
        return Hashset[index1]!= null && Hashset[index1][index2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
