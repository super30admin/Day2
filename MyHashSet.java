// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :  NO
class MyHashSet {
    // as key size limit is 10^6; first array size is root of 10^6
    
    boolean[][] myhashset;
    int buckets;
    int items;

    public MyHashSet() {
        this.buckets=1000;
        this.items=1000;
        this.myhashset= new boolean[buckets][]; 
    }
    
    public void add(int key) {
        int bucket = key % buckets;
        int item = key/items;
        if(myhashset[bucket]==null){
            if(bucket ==0){
                 myhashset[bucket]= new boolean[items+1];
            }   
            else{
             myhashset[bucket] = new boolean[items];
            }
        }
        myhashset[bucket][item]=true;
    }
    
    
    public void remove(int key) {
        int bucket= key % buckets;
        if(myhashset[bucket]!=null){
            int item= key/items;
            myhashset[bucket][item]=false;
        }
    }
    
    public boolean contains(int key) {
        int bucket= key % buckets;
        int item= key/items;
        if(myhashset[bucket]==null){
            return false;
        }
        return myhashset[bucket][item];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */