import java.util.*;
class MyHashSet {
    
    int[] set;
    /** Initialize your data structure here. */
    public MyHashSet() {
       set = new int[1000000];
        Arrays.fill(set, -1);
    }
    
    public void add(int key) {
        set[key] = key;
    }
    
    public void remove(int key) {
        set[key] = -1;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return (set[key] != -1);
    }

    public static void main(String args[])
    {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);         
        hashSet.add(2);         
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);          
        hashSet.contains(2);    // returns true
        hashSet.remove(2);          
        hashSet.contains(2);    // returns false (already removed)
    }
}
