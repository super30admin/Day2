//The code ran but takes a lot of time . Complexity for add-O(n), remove-O(n),contains-O(n)
class MyHashSet {

    /** Initialize your data structure here. */
    
    LinkedList<Integer> hashset[];
    int hash;
    public MyHashSet() {
       
        hash=2096;  
         hashset= new LinkedList[hash];
        for(int i=0;i<hash;i++)
            hashset[i]=new LinkedList<Integer>();
    }
    
    public void add(int key) {
         if(hashset[key%hash]!=null && hashset[key%hash].contains(key))
              return;
        hashset[key%hash].add(key);
    }
    
    public void remove(int key) {
        if(hashset[key%hash]!=null && hashset[key%hash].contains(key))
            hashset[key%hash].remove(new Integer(key));
        return;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(hashset[key%hash].contains(key))
            return true;
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