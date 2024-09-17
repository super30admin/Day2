// Time Complexity : o(1)
// Space Complexity : o(1000001)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Using two Stacks and implementing costly pop operation

class MyHashSet {

    /** Initialize your data structure here. */
    //Using a boolean array and initializing it to size 1000001. By default all the indexes will have a false value.
    boolean[] hashSet;
    public MyHashSet() {
       hashSet = new boolean[1000001];
    }
    
    public void add(int key) {
        //change the value of the index/key to true
        hashSet[key] = true;
    }
    
    public void remove(int key) {
        //change the value the the index/key to false 
        hashSet[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        //if the key is present, then it will contain the value true else false.
        return hashSet[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

class Main { 
    public static void main(String args[]) 
    { 
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);         
        hashSet.add(2);         
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);          
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);          
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    } 
}