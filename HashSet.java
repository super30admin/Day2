// Time Complexity : O(1) for add and O(n) to remove
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Need to thing on a better approach


// Your code here along with comments explaining your approach


class MyHashSet {
    List<Integer> list = new ArrayList<Integer>();
    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        if(!list.contains(key)){
            list.add(key);
        }
    }
    
    public void remove(int key) {
        list.remove(new Integer(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return list.contains(key);
    }
}
