class MyHashSet {
    boolean[] arrayhash;

    /** Initialize your data structure here. */
    public MyHashSet() {
        arrayhash = new boolean[1000];
    }
    
    public void add(int key) {
        if(key>=arrayhash.length){
            doubleArray(key);
        }
        arrayhash[key] = true;
    }
    
    public void remove(int key) {
        if(key>=arrayhash.length){
            doubleArray(key);
        }
        arrayhash[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(key>=arrayhash.length){
            doubleArray(key);
        }
        boolean iscontained = arrayhash[key];
        return iscontained;
    }
    
    public void doubleArray (int key){
        arrayhash = Arrays.copyOf(arrayhash, key+1);  
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */