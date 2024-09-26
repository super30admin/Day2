// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashSet {

    boolean bucket[][];
    int bucketsize;
    int bucketitemsize;
    
    public MyHashSet() {
        bucketsize=1000;
        bucketitemsize=1000;
        bucket=new boolean[bucketsize][];    
    }
    
    // double hashing for efficient collision handling
    public int getbucketkey(int key){
        return key%bucketsize;
    }
    
    public int getbucketitemkey(int key){
        return key/bucketitemsize;
    }
    
    public void add(int key) {
        int b=getbucketkey(key);
        int bi=getbucketitemkey(key);
        if(bucket[b]==null){
            if(b==0){
                //for value of key 10^6. 
            bucket[b]=new boolean[bucketitemsize+1];
            }
            else{
                bucket[b]=new boolean[bucketitemsize];
            }
        }
        bucket[b][bi]=true;
    }
    
    public void remove(int key) {
        int b=getbucketkey(key);
        if(bucket[b]!=null){
            int bi=getbucketitemkey(key);
            bucket[b][bi]=false;
    }
    }
    public boolean contains(int key) {
        int b=getbucketkey(key);
        if(bucket[b]!=null){
            int bi=getbucketitemkey(key);
            return bucket[b][bi];
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