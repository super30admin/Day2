import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Time Complexity : O(1)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
*/

class MyHashSet {

	int initCapacity = 100;
	List <List<Integer>> hashSet = null;


    public MyHashSet() {
    	hashSet = new ArrayList <>();
        for (int i = 0; i < initCapacity; i++) {
            hashSet.add (null);
        }
    }

    public void add(int key) {
    	int hash = hashing (key);
        List <Integer> values = hashSet.get(hash);
        if (values == null) {
            values = new LinkedList<>();
            values.add (key);
            hashSet.set (hash, values);
        } else if (!values.contains (key))
            values.add (key);
        
    }
    
    public void remove(int key) {
    	
    	int hash = hashing (key);
        List <Integer> values = hashSet.get(hash);
        if (values != null && values.contains (key)) {
            values.remove (Integer.valueOf(key));
        }
        
    }
    
    public boolean contains(int key) {
    	
    	int hash = hashing (key);
        List <Integer> values = hashSet.get(hash);
        return values != null && values.contains (key);
        
    }
    
    private int hashing (int key) {
        return key % initCapacity;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */