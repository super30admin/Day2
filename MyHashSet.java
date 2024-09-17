// Time Complexity: 
    //For bucket: getBucket O(1), add O(N), remove O(1), isEmpty O(1)
    //For HashSet: add O(N), remove O(N), contains O(N)
// Space Complexity: Not too clear.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Space complexity seems a bit difficult. Also forgot to ignore duplicates when adding to hashset. 

class Bucket {
    List<Integer> bucket;
    
    Bucket(){
        this.bucket = new ArrayList<Integer>();
    }
    public List<Integer> getBucket(){
        return this.bucket;
    }
    
    public void add(int x){
        boolean foundX = false;
        for(Integer i : bucket){
            if(i == x) foundX = true;
        }
        if(!foundX) this.bucket.add(x);
    }
    
    public void remove(int x){
        this.bucket.remove(x);
    }
    
    public boolean isEmpty(){
        return this.bucket.size() == 0;
    }
    
    
}

class MyHashSet {
    
    Bucket[] set = new Bucket[770];
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        int index = key % 769;
        if(set[index] == null){
            set[index] = new Bucket();
            set[index].add(key);     
        }else{
            set[index].add(key);     
        }
    }
    
    public void remove(int key) {
        int index = key % 769;
        int removeIndex = -1;
        if(set[index] != null && !set[index].isEmpty()){
            Bucket bucketObj = set[index];
            List<Integer> bucket = bucketObj.bucket;
            for(int i = 0; i < bucket.size(); i++){
                int storedKey = bucket.get(i);
                if(key == storedKey){
                    removeIndex = i;
                }
            }
            
            if(removeIndex != -1){
                bucket.remove(removeIndex);
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % 769;
        if(set[index] != null && !set[index].isEmpty()){
            Bucket bucketObj = set[index];
            List<Integer> bucket = bucketObj.bucket;
            for(Integer storedKey: bucket){
                if(storedKey == key) return true;
            }
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