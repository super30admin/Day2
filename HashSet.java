class MyHashSet {
    
    ArrayList<Integer> l;

    /** Initialize your data structure here. */
    public MyHashSet() {
        l = new ArrayList<>();
    }
    
    public void add(int key) {
        if(l.contains(key)==false)
        {
            l.add(key);
        }      
    }
    
    public void remove(int key) {
        if(l.contains(key)){
            int y =l.indexOf(key);
            l.remove(y);
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return l.contains(key);
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

//time complexity is O(n) for all the operations-bruteforce solution
