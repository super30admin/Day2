// Time Complexity :??.. add-> O(1).. remove-> depending upon values in innerlist.. contain-> depending upon values in innerlist 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Spent more than an hour to finally figure out that for removing an integer from java list we need it to convert is to an object using boxing.


// Your code here along with comments explaining your approach
//basically this hashset is an arraylist of linkedlists. so I used list operations to define hashset operations.


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashSet {

	final int max_range=1000000;
	int array_length=50;
	List<List<Integer>> lists;
	
    /** Initialize your data structure here. */
    public MyHashSet() {
        lists=new ArrayList<>(array_length);
        for(int i=0; i<array_length; i++) {
        	lists.add(null);
        }
    }
    
    public void add(int key) {
        int index=key % array_length;
        List<Integer> list= lists.get(index);
        if(list==null){
        	List<Integer> innerList=new LinkedList();
        	innerList.add(key);
        	lists.set(index, innerList);
        }else if(!list.contains(key)) {
        	list.add(key);
        }
        
    }
    
    public void remove(int key) {
    	 int index=key % array_length;
    	 List<Integer> list= lists.get(index);
    	 if((list!=null)) {
    		 list.remove(Integer.valueOf(key));
    	 }
    	 
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        boolean ans=false;
    	int index=key % array_length;
   	 List<Integer> list= lists.get(index);
   	if((list!=null)) {
		 ans=list.contains(key);
	 }
        return ans;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */