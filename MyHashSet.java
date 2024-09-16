// Time Complexity : add O(1), remove O(1), contains O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {

    //Using double hashing

    private static int H1_helper = 1000;
    private static int H2_helper = 1000;
    
    private boolean[][] arr;
    
    public MyHashSet() {
        //initialize the first array
        arr = new boolean[H1_helper][];
    }

    //using modulus operation for 1st hash
    private int hash1(int key) {
        return (key%H1_helper);
    }
    
    //using division operation for 2nd hash
    private int hash2(int key) {
        return (key / H2_helper);
    }
    
    public void add(int key) {
        //add only if key is not already present
        if(!contains(key)) {
            int h1 = hash1(key); //get the first hash
            if(arr[h1] == null) { // if no elements in the first hash location - init the second array
                arr[h1] = new boolean[H1_helper+1];
            }
            
            //get 2nd hash and add to hashSet
            int h2 = hash2(key);
            arr[h1][h2] = true;
        }
    }
    
    public void remove(int key) {
        //if key doesnt exist in HashSet then return
        //Else get the two hashes and set the location as false
        if(contains(key)) {
            int h1 = hash1(key);
            int h2 = hash2(key);
            
            arr[h1][h2] = false;
        }
    }
    
    public boolean contains(int key) {
        //get first hash
        int h1 = hash1(key);
        // if the 1st hash location is empty then key doesn't exist
        if(arr[h1] == null) {
            // no element in the array if the first hash is empty
            return false;
        }
        // else get 2nd hash and return the value at [h1][h2]
        int h2 = hash2(key);
        return arr[h1][h2];    
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */