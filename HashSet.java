// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
    Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
    /** Initialize your data structure here. */
    public MyHashSet() {
    }

    public void add(int key) {
        if(!myMap.containsKey(key)){
            myMap.put(key,1);
        }
    }

    public void remove(int key) {
        if(myMap.containsKey(key)){
            myMap.remove(key,1);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return myMap.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */