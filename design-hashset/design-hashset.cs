        return key / buckets;
    }
    
    public void Add(int key) {
        int index1 = Hash1(key);
        int index2 = Hash2(key);
        if(storage[index1]==null)
        {
            storage[index1] = new bool[bucketitems];
            
        }
        storage[index1][index2] = true;
        
    }
    
    public void Remove(int key) {
        
          int index1 = Hash1(key);
        int index2 = Hash2(key);
        if(storage[index1]==null)
        {
            return;
            
        }
        storage[index1][index2] = false;
        
        
    }
    
    /** Returns true if this set contains the specified element */
    public bool Contains(int key) {
          int index1 = Hash1(key);
        int index2 = Hash2(key);
        if(storage[index1]==null)
        {
           return false;
            
        }
        return storage[index1][index2] ;
        
        
    }
}
​
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
