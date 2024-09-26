// Time Complexity :  All the operations are O(N). Find, Add and remove.
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I didn't account for the fact that there could be multiple numbers
// with the same mod result with a prime number.

// Your code here along with comments explaining your approach
// So each index represents a mod value when the key is divided by the hashKey, which is a prime number.
// Each index is pointing to an object of class Bucket.
// Class Bucket has an ArrayList to store the elements that when devided by the hashKey prime number
// leave the remainder equal to the corresponding index in the hashSet.
class MyHashSet {
    
    class Bucket{
        ArrayList<Integer> bucket = new ArrayList<Integer>();
        
        public boolean find(int key){
            for(int i=0;i<bucket.size();i++){
                if(bucket.get(i)==key){
                    return true;
                }
            }
            return false;
        }
        
        public void findAndremove(int key){
            int len = bucket.size();
            for(int i=0;i<len;i++){
                if(bucket.get(i) == key){
                    bucket.remove(i);
                    break;
                }
            }
        }
        
    }
    
    int keySize;
    Bucket[] hset;
    /** Initialize your data structure here. */
    public MyHashSet() {
        keySize = 2069;
        hset = new Bucket[keySize];
        Arrays.fill(hset, new Bucket());
    }
    
    public void add(int key) {
        int index = key%keySize;
        Bucket bucketPointer = hset[index];
        if(bucketPointer.find(key) == false){
            bucketPointer.bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int index = key%keySize;
        Bucket bucketPointer = hset[index];
        bucketPointer.findAndremove(key);
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key%keySize;
        Bucket bucketPointer = hset[index];
        if(bucketPointer.find(key)){
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