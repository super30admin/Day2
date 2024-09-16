class MyHashSet {
        int[] hs;


    public MyHashSet() {
        hs = new int[1000001];
        Arrays.fill(hs,-1);
        
    }
    
    public void add(int key) {
        if( !(contains(key)))
            hs[key]=key;
            
        
    }
    
    public void remove(int key) {
        if(contains(key)){
            hs[key]=-1;
        }
        
    }
    
    public boolean contains(int key) {
        if (hs[key]!=-1)return true;
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
