// Time Complexity : O(1) all operations
// Space Complexity : O(N * k), N = array length K = arrayList length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Null Pointer Exception (add opr if cond), Index Out of Bounds(remove method obj not prim)   

// Your code here along with comments explaining your approach

class MyHashSet {

    List<Integer>[] arr;
    
    int generateHash(int key) {
        int hash = key % 103;
        return hash;
    }
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        int n = 103;
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) { 
            arr[i] = new ArrayList<Integer>(); 
        }
    }
    
    public void add(int key) {
        int hash = generateHash(key);
        
        if (!arr[hash].contains(key)) { 
            arr[hash].add(key);
        }
        
    }
    
    public void remove(int key) {
        int hash = generateHash(key);        
                
        if (arr[hash].contains(key)) {
            arr[hash].remove(new Integer(key));
        }          
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = generateHash(key);                  
        return (arr[hash].contains(key));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */