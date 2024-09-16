// Time Complexity : O(1) Amortized for add()
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class MyHashSet {
    
    List<Integer> hashSet[];
    
    //Setting initial capacity
    int capacity = 1000;
    //setting load factor to 80% increase list size when 80% filled
    double loadFactor = 0.80;
    //count to track for rehashing
    int count = 0;
    

    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new LinkedList[capacity];
    }
    
    // Calculate hash and append key to linkedlist 
    // at index of hash
    public void add(int key) {
        if(contains(key)) return;
        
        //check if 80% limit reached and resize and rehash
        if(loadFactor*capacity == count){
            reHash();
        }
        int hash = key % capacity;
        if(hashSet[hash] == null)
            hashSet[hash] = new LinkedList<>();
        hashSet[hash].add(key);
        ++count;
    }
    
    public void remove(int key) {
        List<Integer> ls = hashSet[key%capacity];
        if(ls==null) return;
        for(int i = 0;i<ls.size();i++) {
            if(ls.get(i)==key) {
                ls.remove(i);
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    //
    public boolean contains(int key) {
        List<Integer> ls = hashSet[key%capacity];
        if(ls==null) return false;
        for(int i = 0;i<ls.size();i++) {
            if(ls.get(i)==key) {
                return true;
            }
        }
        return false;
    }
    
    
    //Once 80% of list is full double size of list and reHash all elements
    public void reHash() {
        count = 0;
        capacity *= 2;
        List<Integer>[] oldHashSet = hashSet;
        hashSet = new LinkedList[capacity];
        for(int i=0; i < oldHashSet.length; i++){
            List<Integer> list = oldHashSet[i];
            if(list != null){
                for(int k : list)
                    this.add(k); 
            }
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
