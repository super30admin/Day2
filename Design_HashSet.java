import java.util.ArrayList;
import java.util.List;

class Design_HashSet {
	
	//Approach: 1. I have created an array of List of integers, and once i get a key, with help of getIndex function will generate an index.
	//2. Will create an object of list of integers with key value and insert it at that index, if it already has a list of integers, 
	//will traverse along to check the key, and will insert on its absence
	//3. Similarly, will do for contains and remove function.
    List<Integer>[] keys;
    /** Initialize your data structure here. */
    public Design_HashSet() {
        keys = new List[1000];
    }
    
    public void add(int key) {
        int index = getHash(key);
        if(keys[index] == null)
        {
            List<Integer> list = new ArrayList<>();
            list.add(key);
            keys[getHash(key)] = list;
        }
        else
        {
            List<Integer> list = keys[index];
            for(int i=0; i < list.size(); i++)
            {
                if(list.get(i) == key)
                    return;
            }
            list.add(key);
        }
    }
    
    public void remove(int key) {
        int index = getHash(key);
        if(keys[index] != null)
        {
            List<Integer> list = keys[index];
            for(int i=0; i < list.size(); i++)
            {
                if(list.get(i) == key)
                    list.remove(i);
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = getHash(key);
        if(keys[index] == null) return false;
        if(keys[index] != null)
        {
            List<Integer> list = keys[index];
            for(int i: list)
            {
                if(i == key)
                    return true;
            }
        }
        return false;
    }
    
    public int getHash(int key)
    {
        return key % 1000;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Design_HashSet obj = new Design_HashSet();
		  obj.add(1);
		  obj.remove(1);
		  boolean param_3 = obj.contains(1);
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

//Time Complexity : O(n) for add, remove, contains operations, since by worst case we might have to iterate through the list of integers. 
//Space Complexity : O(n), where n is the number of elements in the Hash Set 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :