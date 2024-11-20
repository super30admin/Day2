// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// 1. Since the key space is restricted to 1000000 elements we use a 2d boolean array to store the elements that we want to add in the set.
// 2. For a given key, we compute two hashes. Hash1 used to find the row index & Hash2 is used to find the col index.
// 3. For a given key, if the corresponding element at first hash is empty 
//    then we initialize the array of second hash size and set the boolean to true at the respective location
// 4. To remove an element we set the corresponding location to false which indicates that there is no element stored at that location.
// 5. To check if an element exists at given location, check if the value is set to true or false.
// 6. we set the column size to 1001 to handle an edge case for element 1000000. 
//    In this scenario the row value will be 1000000 % 1000 = 0 and col value will be 1000000 / 1000 = 1000 and the index of 1000 sized array ends at 999.

class MyHashSet {
    
    boolean[][] hash;
    int firsthash;
    int secondhash;

    /** Initialize your data structure here. */
    public MyHashSet() {
        firsthash = 1000;
        secondhash = 1001;
        hash = new boolean[firsthash][];
    }
    
    public void add(int key) {
        int hash1 = key % firsthash;
        int hash2 = key / secondhash;
        if(hash[hash1] == null){
            hash[hash1] = new boolean[secondhash];
        }
        hash[hash1][hash2] = true;
    }
    
    public void remove(int key) {
        int hash1 = key % firsthash;
        int hash2 = key / secondhash;
        if(hash[hash1] == null) return;
        hash[hash1][hash2] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash1 = key % firsthash;
        int hash2 = key / secondhash;
        if(hash[hash1] == null) return false;
        return hash[hash1][hash2];
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(2);
        obj.remove(3);
        boolean param_2 = obj.contains(2);
        boolean param_3 = obj.contains(5);
        System.out.println(param_2);
        System.out.println(param_3);
    }
}
