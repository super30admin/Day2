  
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashSet {
    
    boolean[][] myhash;
    int firsthash;
    int secondhash;
    /** Initialize your data structure here. */
    public MyHashSet() {
        firsthash=1000;
        secondhash=1001;
        myhash=new boolean[firsthash][];
    }
    
    public void add(int key) {
        int key1=key%firsthash;
        int key2=key/firsthash;
        if(myhash[key1]==null)
            myhash[key1]=new boolean[secondhash];
        myhash[key1][key2]=true;
    }
    
    public void remove(int key) {
        int key1=key%firsthash;
        int key2=key/firsthash;
        if(myhash[key1]==null)
            return;
        myhash[key1][key2]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int key1=key%firsthash;
        int key2=key/firsthash;
        if(myhash[key1]==null)
            return false;
        return myhash[key1][key2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
