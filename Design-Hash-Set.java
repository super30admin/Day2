class MyHashSet {
 
    public int[] arr;
    /** Initialize your data structure here. */
    public MyHashSet() {
        
        arr = new int[1000001];
        
    }
    
    public void add(int key) {
        
        arr[key] = key;
        
    }
    
    public void remove(int key) {
        
        arr[key] = 0;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        if(arr[key] != 0)
            return true;
        else 
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