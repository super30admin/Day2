// Time Complexity : O(1)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {
     boolean[][] hashSet;
     int hash1;
     int hash2;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet= new boolean[1000][];
        hash1=1000;
        hash2=1000;
    }
    
    public int getFirstIndex(int key)
    {
        return key%hash1;
    }
    public int getSecondIndex(int key)
    {
        return key/hash2;
    }
    
    public void add(int key) {
        int index1=getFirstIndex(key);
        int index2=getSecondIndex(key);
        if(hashSet[index1]==null)
        {
        	if(index1==0)
        	{
        		hashSet[index1]=new boolean[1001];
        	}
        	else
        	{
        		hashSet[index1]=new boolean[1000];
        	}       
        }
        hashSet[index1][index2]=true;
    }
    
    public void remove(int key) {
    	int index1=getFirstIndex(key);
        int index2=getSecondIndex(key);
        if(hashSet[index1]==null) 
        	return;
        
        hashSet[index1][index2]=false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	int index1=getFirstIndex(key);
        int index2=getSecondIndex(key);
        if(hashSet[index1]==null) 
        	return false;
        else 
        	return hashSet[index1][index2];
    }
    
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */