// Time Complexity : O(N/K)
// Space Complexity : O(M+K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
import java.util.LinkedList;
class Bucket{
    LinkedList<Integer> list;
    public Bucket(){
        list = new LinkedList<>();
        
    }
    public void insert(int key){
        //If the key doesn't exist, add to list.
       if(!exists(key))
           list.add(key);
        
    }
    public void delete(int key) {
        //System.out.println(key);
        if(exists(key))
            list.remove(list.indexOf(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean exists(int key) {
    
    return list.contains(key);
    }
}

class MyHashSet {
    private Bucket[] arr;
    private int k;

    /** Initialize your data structure here. */
    public MyHashSet() {
        k = 2003;
        arr = new Bucket[k];
        for(int i=0; i<k; i++){
            arr[i]= new Bucket();
        }
        
    }
    
    public void add(int key) {
        int hash = key%k;
        arr[hash].insert(key);
        
        
    }
    
    public void remove(int key) {
        int hash = key%k;
        arr[hash].delete(key);
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key%k;
        return arr[hash].exists(key);
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */