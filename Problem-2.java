// Time Complexity : O(N/C) , C - number of chains, 811 in our case, prime number to avoid collisions 
// Space Complexity : O(C + V) , C- same as before, V - number of unique values inserted
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    private Chain[] chains;
    private int maxSize;
    
    public MyHashSet() {
        maxSize=811;
        chains = new Chain[maxSize];
        
        for(int i=0;i<maxSize;i++)
            chains[i] = new Chain();
    }
    
    private int getHash(int val){
        return val % maxSize;
    }
        
    
    public void add(int key) {
        int index = getHash(key);
        chains[index].insert(key);
    }
    
    public void remove(int key) {
        int index = getHash(key);
        chains[index].delete(key);
    }
    
    public boolean contains(int key) {
      int index = getHash(key);
       return chains[index].isPresent(key);
    }
}

class Chain {
    private LinkedList<Integer> container;
    
    public Chain(){
        container = new LinkedList<>();
    }
    //inserting at the head to be able to access the recently used value easily
    public void insert(Integer val){
        int found = container.indexOf(val);
        
        if(found==-1)
            container.addFirst(val);
    }
    
    public void delete(Integer val){
        container.remove(val);
    }
    
    public boolean isPresent(Integer val){
        return (container.indexOf(val)!=-1);
    }
}

