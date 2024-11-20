import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {

    List<Integer> set;
    public MyHashSet() {
        set=new ArrayList<>();
    }
    
    public void add(int key) {
        if(contains(key)){
            return;
        }        
    set.add(key);
    }
    
    public void remove(int key) {
        for(int i=0;i<set.size();i++){
            if(set.get(i)==key){
                set.remove(i);
            }
        }   
    }
    
    public boolean contains(int key) {
         for(int i:set){
            if(i==key){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
