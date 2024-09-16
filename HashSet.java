// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class HashSet {
     
    boolean[] arr;
    
    public HashSet() {
        arr = new boolean[100];
    }
    
    public void add(int key) {
        // If array is small we extend the key
        if(key>=arr.length) 
            extend(key);
        arr[key]=true;
    }
    
    public void remove(int key) {
        if(key>=arr.length) 
            extend(key);
        arr[key]=false;
    }
    
    // Here I am returning true if the hash set has the spicified element
    public boolean contains(int key) {
        if(key>=arr.length)
            return false;
        return arr[key]==true;
    }
    
    //applying the concept of more the base array less collision will occur but increasing the space complexity
    public void extend(int key){
        arr= Arrays.copyOf(arr, key+2);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */