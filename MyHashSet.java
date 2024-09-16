import java.util.LinkedList;
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashSet {
    LinkedList<Integer>[] list;
    int size = 1000000;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        list = new LinkedList[size];
        
    }
    
    public void add(int key) {
        int hashcode = key % size;
        if(list[hashcode] == null){
            list[hashcode] = new LinkedList();
            list[hashcode].add(key);     
        }else{
            if(!list[hashcode].contains(key)){
                list[hashcode].add(key);
            }
        }
            
           
        }
    
    
    public void remove(int key) {
        int hashcode = key % size;
        if(list[hashcode] != null){
            list[hashcode].remove(Integer.valueOf(key));              
        }else{
            return;
        }

        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashcode = key % size;
       
        return list[hashcode] != null && list[hashcode].contains(key);

    }
}

