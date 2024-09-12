class MyHashSet {

    
   ArrayList<Integer> hs;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        hs = new ArrayList<Integer>();
    }
    
    public void add(int key) {
        
        for(int i=0;i<hs.size();i++)
        {
            if(hs.get(i)==key)
            {
                return;
            }
            
           
        }
         hs.add(key);
    }
    
    public void remove(int key) {
        
        for(int i=0;i<hs.size();i++)
        {
            if(hs.get(i)==key)
            {
                hs.remove(i);
                return;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
        for(int i=0;i<hs.size();i++)
        {
            if(hs.get(i)==key)
            {
              //  hs.remove(i);
                return true;
            }
        }
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
