// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, just not sure about the space complexity.Will it be O(n) for removal? since we have to create n integer objects.

class MyHashSet {

    List<Integer> list;
    
    public MyHashSet() {
        list = new ArrayList<>();
    }
    
	//only add if the element is not present in the list
    public void add(int key) {
        if(!list.contains(key))
            list.add(key);
    }
    
	//removes if the key is present
    public void remove(int key) {
        list.remove(new Integer(key));
    }
    
	//Return if key is present or not
    public boolean contains(int key) {
        return list.contains(key);
    }
}
