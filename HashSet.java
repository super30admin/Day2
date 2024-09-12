// Time Complexity : O(n)
// Space Complexity : O(n); 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Bucket {
    List<Integer> list;
    
    public Bucket(){
        list  = new LinkedList<>();
    }
    
    // to insert the keys according to the hash ito respective indices
    public void insert(int key){
        if(!keyExists(key)){
            list.add(key);
        }
    }
    
    public void delete(int key){
        if(keyExists(key)){
            list.remove(list.indexOf(key));
        }
    }
    
    //to check if the key we want to add is presetn or not
    public boolean keyExists(int key){
        return list.contains(key);
    }
}

class MyHashSet {

    Bucket[] hs;
    int size_of_hs;
    /** Initialize your data structure here. */
    public MyHashSet() {
        size_of_hs = 10000;
        hs = new Bucket[size_of_hs];
        for(int i= 0;i<size_of_hs;i++){
            hs[i] = new Bucket();
        }
    }
    
    public int hashCode(int key){
        return key % size_of_hs;
    }
    
    public void add(int key) {
        int hash = hashCode(key);
        hs[hash].insert(key);
    }
    
    public void remove(int key) {
        int hash = hashCode(key);
        hs[hash].delete(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hashCode(key);
        return hs[hash].keyExists(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */