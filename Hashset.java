// Time Complexity : O(n)
// Space Complexity : 0(Number of buckets + value)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes , implementing bucket class


// Your code here along with comments explaining your approach
class MyHashSet {
  
    int Bucket bucket[];
    int buckNum;
    /** Initialize your data structure here. */
    public MyHashSet() {
       buckNum =10001;
       bucket = new Bucket[buckNum];
    }
    
    //add value into hashset
    public void add(int key) {
        int buckID = hashBucket(key);
        if(buckets[buckID]==null){
            buckets[buckID] = new Bucket();
            buckets[buckID].setElement(key,key);
        }
    }
    
    //hashing
    private int hashBucket(int key){
        return key % buckNum;
    }
    // remove element
    public void remove(int key) {
        int buckID = hashBucket(key);
        if(contains(key)){
            buckets[buckID].setElement(key , -1);
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int buckID = hashBucket(key);
        return buckets[buckID]!=null && buckets[buckID].getElement(key) != -1;
    }
    
    public boolean contains(int key) {
        int buckID = hashBucket(key);
        return buckets[buckID] != null && buckets[buckID].getItem(key) != -1;
    }
    
    
    //bucket class
    class Bucket {
        int elementNum;
        int element[];
        
        public Buckets(){
            elementNum = 1001;
            element = new int[elementNum];
            init();
        }
        
        public void init(){
            for(int i = 0; i < elementNum; i++)
                elementNum[i] = -1;
        }
        public void setElement(int key,int value){
            int index = hashItem(key);
            element[index] = value;
        }
        
        public int getElement(int key){
            int index = hashItem(key);
            return element[index];
        }
        public int hashItem(int key){
            return key / elementNum;
        }
        
    }
}
