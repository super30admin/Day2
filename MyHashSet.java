// Time Complexity : O(1) for all
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Read about different ways to do this problem on internet and then came up with a straight forward solution by using boolean array.
//                                           Then used double hashing to do thiis problem


// Your code here along with comments explaining your approach

public class MyHashSet {
    // We will store the elements in 2D matrix in double hashed format.
    // bucketsize and sec_buckets is determined based on input range and here
    // I am choosing sqrt of input array range(1000000) which is 1000
    int bucketsize=1000;
    int sec_buckets=1000;
    boolean[][] m=new boolean[bucketsize][];
    public MyHashSet() {

    }
    private int primary_hash(int key) {
        return key%bucketsize;
    }
    private int secondary_hash(int key) {
        return key/sec_buckets;
    }
    /* Compute hashcode which gives us index where to insert the set.
    Check if secondary array is initialised at primary index location.
    Else, initialise and set true at index
    */
    public void add(int key) {
        int bucketnum = primary_hash(key);
        int sec_bucknum=secondary_hash(key);
        if(m[bucketnum]==null){
            m[bucketnum]=new boolean[sec_buckets];
        }
        m[bucketnum][sec_bucknum]=true;
    }
    // if the bucket is found by same above method, then initialise it to false 
    public void remove(int key){
        int bucketnum = primary_hash(key);
        int sec_bucknum=secondary_hash(key);
        if(m[bucketnum]!=null){
            m[bucketnum][sec_bucknum]=false;
        }
    }
    public boolean contains(int key) {
        int bucketnum = primary_hash(key);
        int sec_bucknum=secondary_hash(key);
        if(m[bucketnum]!=null){
            return m[bucketnum][sec_bucknum];
        }
        return false;
    }
}