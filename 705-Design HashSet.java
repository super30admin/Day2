//Time complexity=O(1)
//Space compplexity=O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashSet {
    boolean hashset[][];
    /** Initialize your data structure here. */
    public MyHashSet() {
       hashset=new boolean[1000][]; 
    }
    
    public void add(int key) {
        if(hashset[BucketNum(key)]==null)
            hashset[BucketNum(key)]=new boolean[1000];
        hashset[BucketNum(key)][BucketItemNum(key)]=true;
    }
    
    public void remove(int key) {
        if(hashset[BucketNum(key)] !=null && hashset[BucketNum(key)][BucketItemNum(key)]==true)
            hashset[BucketNum(key)][BucketItemNum(key)]=false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(hashset[BucketNum(key)] !=null && hashset[BucketNum(key)][BucketItemNum(key)]==true)
            return true;
        return false;
    }
    
    private int BucketNum(int key)
    {
        return key%1000;
    }
    private int BucketItemNum(int key)
    {
        return key/1000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */