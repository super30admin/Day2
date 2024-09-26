// Time Complexity : primary_hash - O(1) || secondary_hash - O(1) || add - O(1) || remove - O(1) || contains - O(1) || So total of O(1) Asymtotic for all operations
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : variables used in the code such as bucketsize, sec_buckets, bucketno and sec_bucketno can become confusing. Confusion can be resolved by making the variable nomenclature articulate


// Your code here along with comments explaining your approach

class MyHashSet { //Initialize 2D matrix to store elements in set in a double hashed format. Initialize two variables to store size of primary bucket(hash) and secondary bucket(hash)
                  //Size of bucketsize and sec_buckets can be decided based on size of input range. In this case, we choose square root of input array range which is 1000 for 1 million as input range
                  //But in case when input range does not have a perfect square root, select multipllication factors as size.
        int bucketsize = 1000;
        int sec_buckets = 1000;
        boolean [][] hashmatrix = new boolean[bucketsize][];
    /** Initialize your data structure here. */
    public MyHashSet() { // Since, we do not initialize secondary hash array from before, we can leave this blank.

    }
    
    private int primary_hash(int key) { //Function to compute hashcode for 1st primary hashset

        return key % bucketsize;
    }
    
    private int secondary_hash(int key) { //Function to compute hashcode for 2nd secondary hashset
        return key / sec_buckets;
    }
    
    public void add(int key) { // compute hash code by calling above both functions, this gives us the index where to insert in the set
                               // check if the secondary array is initialized at the primary index location. If not, initialize and then set true at index 
        int bucketno = primary_hash(key);
        int sec_bucketno = secondary_hash(key);
        if(hashmatrix[bucketno] == null)
        {
            hashmatrix[bucketno] = new boolean[sec_buckets];
        }
        hashmatrix[bucketno][sec_bucketno] = true;
    }
    
    
    public void remove(int key) { //follow exact same steps as add function to compute hash code. Then, if the secondary hashset is initialized at the primary hashset index, set false at the computed index without any further checking. 
        int bucketno = primary_hash(key);
        int sec_bucketno = secondary_hash(key);
        if(hashmatrix[bucketno] != null)
        {
            hashmatrix[bucketno][sec_bucketno] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) { // follow exact same steps as add function to compute hash code. Then, if the secondary hashset is initialized at the primary hashset index, return true if true is present at the index, else return false. 
        int bucketno = primary_hash(key);
        int sec_bucketno = secondary_hash(key);
        if(hashmatrix[bucketno] != null)
        {
           return hashmatrix[bucketno][sec_bucketno];
        }
        return false;
    }
    
}

// Class with main function
class Main
{
    public static void main(String[] args)
    {
    MyHashSet hashSet = new MyHashSet();
    hashSet.add(1);         
    hashSet.add(2);         
    System.out.println("Does the hashset contain element 1 - " + hashSet.contains(1)); // returns true
    System.out.println("Does the hashset contain element 3 - " + hashSet.contains(3));    // returns false (not found)
    hashSet.add(2);          
    System.out.println("Does the hashset contain element 2 - " + hashSet.contains(2));    // returns true
    hashSet.remove(2);          
    System.out.println("Does the hashset contain element 2 - " + hashSet.contains(2));   // returns false (already removed)
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */