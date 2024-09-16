// Time Complexity : O(N/K) 
	// n - number of all possible values  
	// k - number of predefined buckets
// Space Complexity :O(M+K)
	//m - number of unique elements say for the linkedlist sake
	//k - number of predefined buckets 

// Did this code successfully run on Leetcode : yes 
// Your code here along with comments explaining your approach

class MyHashSet {
    
    private Bucket[] bucketArray;
    private int keyRange;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for(int i =0; i< this.keyRange; ++i){
            this.bucketArray[i] = new Bucket();
        }
    }
        
    protected int _hash(int key){
        return (key % this.keyRange);
    }
    
    public void add(int key) {
        int Index = this._hash(key);
        this.bucketArray[Index].insert(key);
    }
    
    public void remove(int key) {
        int Index = this._hash(key);
        this.bucketArray[Index].delete(key);
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int Index = this._hash(key);
        return this.bucketArray[Index].exists(key);
    }
}

class Bucket{
    
    private LinkedList<Integer> container;
    
    public Bucket(){
        container = new LinkedList<Integer>();
    }
    
    public void insert(Integer key){
        int index = this.container.indexOf(key);
        //if the linkedlist is empty then insert into it
        if(index == -1){
            this.container.addFirst(key);
        }
    }
    
    public void delete(Integer key){
        this.container.remove(key);
    }
    
    public boolean exists(Integer key){
        int index = this.container.indexOf(key);
        return (index != -1);
    }
}


