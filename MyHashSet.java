// Time Complexity :o(1)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no 

class MyHashSet {

    int arr1;
    int arr2;
    boolean[][] hash;
    /** Initialize your data structure here. */
    public MyHashSet() {
        arr1 = 1000;
        arr2 = 1001;
        hash = new boolean[arr1][];
    }
    
    private int keyArray(int key){
        int key1 = key % arr1;
        return key1;
    }
    private int keyArray1(int key)
    {
        int key2 = key / arr2;
        return key2;
    }
    public void add(int key) {
        int h_key = keyArray(key);
        int v_key = keyArray1(key);
        if (hash[h_key] == null)
        {
            hash = new boolean[arr1][arr2];
        }
        hash[h_key][v_key] = true;
    }
    
    public void remove(int key) {
        int h_key = keyArray(key);
        int v_key = keyArray1(key);
        hash[h_key][v_key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h_key = keyArray(key);
        int v_key = keyArray1(key);
        return hash[h_key][v_key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */ 