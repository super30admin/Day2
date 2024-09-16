class MyHashSet {
    
    ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public MyHashSet() {
        
        list = new ArrayList<>();
        
    }
    
    public void add(int key) {
        
        list.add(key);
        
    }
    
    public void remove(int key) {
        
        if(list.contains(key)){
            ArrayList<Integer> list2 = new ArrayList<>();
            list2.add(key);
            list.removeAll(list2);
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        return list.contains(key);
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */