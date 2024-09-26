class MyHashSet {

    /** Initialize your data structure here. */
    int bucket = 1000;
    int bucketItem = 1000;
    boolean[][] buckets = new boolean[bucket][];
    
    public MyHashSet() {
        //Do Nothing    
    }
    
    //HashFunction to get the address of the memory where the val will be stored
    private int getIndex(int val){
        return val%bucket;
    }
    
    //2nd HashFunction to handle collision where bounds are specified - Double Hashing
    private int getIndex2(int val){
        return val/bucket;
    }
    
    //Time Complexity : O(1)
    public void add(int key) {
        int index = getIndex(key);
        if(buckets[index] == null){
            buckets[index] = new boolean[bucketItem];
        }
        int index2 = getIndex2(key);
        buckets[index][index2] = true;
    }

    //Time Complexity : O(1)
    public void remove(int key) {
        int index = getIndex(key);
        int index2 = getIndex2(key);
        if(buckets[index] != null){
            buckets[index][index2] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    //Time Complexity : O(1)
    public boolean contains(int key) {
        int index = getIndex(key);
        int index2 = getIndex2(key);
        if(buckets[index] != null){
            return buckets[index][index2] == true;   
        }
        return false;
    }
}

class Main{
    public sttaic void main(String[] args){
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);         
        hashSet.add(2);         
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);          
        hashSet.contains(2);    // returns true
        hashSet.remove(2);          
        hashSet.contains(2);
    }
}