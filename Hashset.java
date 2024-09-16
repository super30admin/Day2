//time complexity: O(1)
//space complexity: O(n^2)
class MyHashSet {

    private boolean hashset[][];
    int bucket ;
    int bucketitems;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashset=new boolean[1000][1001];
       
    }
    
    public void add(int key) {
        bucket = key%1000;
        bucketitems=key/1000;
        hashset[bucket][bucketitems]=true;
        
        
    }
    
    public void remove(int key) {
        bucket = key%1000;
        bucketitems=key/1000;
        if (hashset[bucket][bucketitems]==true)
        {
            hashset[bucket][bucketitems]=false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        bucket = key%1000;
        bucketitems=key/1000;
        if(hashset[bucket][bucketitems]==true)
        {
            return true;
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
