//Problem 2 Design Hashset
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashSet {
    
    int[] array;

    public MyHashSet() {
        
        array = new int[1000001];
        
    }
    
    public void add(int key) {
        array[key] = 1;
        
        
    }
    
    public void remove(int key) {
        
        array[key] = 0;
    }
    
    public boolean contains(int key) {
        
        if(array[key]==1){
            return true;
        }else{
            return false;
        }
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */