//Time Complexity : O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : I, earlier, implemented this problem in different way which was not optimal solution.


class MyHashSet {
	int primaryBuckets;
	int SecondaryBuckets;
	boolean[][] store;
    /** Initialize your data structure here. */
    public MyHashSet() {
    	primaryBuckets = 1000;
    	SecondaryBuckets = 1001;
    	store = new boolean[primaryBuckets][];
    }
    
    private int firstHashing(int key)
    {
    	return key % 1000;
    }
    
    private int secondHashing(int key)
    {
    	return key / 1000;
    }
    
    public void add(int key) {
        int index1 = firstHashing(key);
        int index2 = secondHashing(key);
        
        if(store[index1] == null)
        {    
        	store[index1] = new boolean[SecondaryBuckets];
        }
        store[index1][index2] = true;
        
    }
    
    public void remove(int key) {
    	int index1 = firstHashing(key);
        int index2 = secondHashing(key);
        
        if(store[index1] == null)
        	return;
        else
        	store[index1][index2] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	int index1 = firstHashing(key);
        int index2 = secondHashing(key);
        
        if(store[index1] == null)
        	return true;
        else
        	return store[index1][index2];
    }
    
    public static void main(String[] args) {
    	MyHashSet myHash = new MyHashSet();
    	
    	myHash.add(6);
    	myHash.add(1006);
    	
    	System.out.println(myHash.contains(1006));
    	
    	myHash.remove(1006);
    	
    	System.out.println(myHash.contains(1006));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */