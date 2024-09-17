
Time Complexity : linear time 

Space COmplexity : 

class MyHashSet {

    private boolean hashSet [][];
     int i ;
        int j ;
    /** Initialize your data structure here. */
    public MyHashSet() {
        
        // boolean set = new boolean ;
        
        hashSet = new boolean [1000][1000]; // Create a 2-d boolean array 
       
        
        
    }
    // Create a matrix like implementation for add/removing 
    public void add(int key) {
        
        i = key/1000; // columns 
        j = key % 1000; // rows (  1-1000 numbers get stored here )
        
        hashSet [i] [j] = true ;
        
    }
    
    public void remove(int key) {
        
         
        i = key/1000;
        j = key % 1000;
        
        if ( hashSet[i] != null)
        { hashSet [ i] [j] = false ;}
        
        
        
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        
       
        
         i = key/1000;
        j = key % 1000;
        
        return hashSet [i][j];
        
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */