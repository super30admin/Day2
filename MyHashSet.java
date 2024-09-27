// Time Complexity : add: O(1)
                     remove: O(1)
                     Contains: O(1)
// Space Complexity : O(k) where K is size of the initial array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I have created a huge array to implement this, so I have compromized space for better runtime.
                                             Can you suggest a better option to limit the space.


class MyHashSet {

    int[] arr = new int[100000];
    
    /** Initialize your data structure here. */
    public MyHashSet() {
       Arrays.fill(arr,0,arr.length,-1); 
    }
    
    public void add(int key) {
        if(arr[key]==-1){
            arr[key] = key;
        }
    }
    
    public void remove(int key) {
        if(arr[key]!=-1){
        arr[key] = -1;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(arr[key]!=-1){
            return true;
        }else
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
