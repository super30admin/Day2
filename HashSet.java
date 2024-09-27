// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initialising the array memory only when the actual bucket value is null;


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean hashSetStorage[][];  
    int buckets;
    int bucketItems;
    
    public MyHashSet() {
        buckets=1000;   //making the initial array size of 1000 elements;
        bucketItems=1000;
        hashSetStorage=new boolean[buckets][]; 
        //only initialising the first storage bucket and not the subsequent 2d array;
    }
    
    public int getBucket(int key){
        return key % buckets;
    }
    
    public int getBucketItem(int key){
        return key / buckets;
    }
    
    public void add(int key) {
        int bucket= getBucket(key);
        int bucketItem=getBucketItem(key);
        if(hashSetStorage[bucket]==null){
            if(bucket==0){
                hashSetStorage[bucket]=new boolean[bucketItems+1];
            }else{
                hashSetStorage[bucket]=new boolean[bucketItems];
            }
        }  
        hashSetStorage[bucket][bucketItem]=true;
    }
    
    
    
    public void remove(int key) {
        int bucket= getBucket(key);
        int bucketItem=getBucketItem(key);
        if(hashSetStorage[bucket]==null){
            return;
        }
        else{
           hashSetStorage[bucket][bucketItem]=false; 
        }
    }
    
    public boolean contains(int key) {
        int bucket= getBucket(key);
        int bucketItem=getBucketItem(key);
        if(hashSetStorage[bucket]==null){
            return false;
        }
        return hashSetStorage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */ 
