/*
	Add Time Complexity : O(1)
	Remove Time Complexity : O(n)
	Contains Time Complexity : O(n)
	
	Space Time Complexity : O(n)
	
	Problem successfully runs on Leetcode.
	
	Url to accepted solution on leetcode: https://leetcode.com/submissions/detail/631723869/ 
*/
import java.util.*;

class MyHashSet {

    ArrayList<Integer> list;
    
    public MyHashSet() {
        this.list = new ArrayList<>();
    }
    
    public void add(int key) {
        this.list.add(key);
    }
    
    public void remove(int key) {
        Iterator itr = this.list.iterator();
        while(itr.hasNext()){
            if(itr.next().equals(key)){
                itr.remove();
            }
        }
    }
    
    public boolean contains(int key) {
        for(int val : this.list){
            if(val == key){
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
