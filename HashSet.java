// Time Complexity :O(1)
// Space Complexity :O(n) n- number of values stored in the hashset
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :-
class MyHashSet {
    //HashSet Using Matrix and Double Hashing
    boolean[][] matrix;
    int buckets;
    int bucketItems;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets=1000;
        bucketItems=1001; // to cover the edge case key - 1000000 we assign 1001 to bucket items
        matrix=new boolean[buckets][];

    }
    
    private int hashBucket(int key)
    {
        return key%buckets; //Hashing to get the index to the row in the matrix
    }
    
     private int hashBucketItems(int key)
    {
        return key/bucketItems;//Hashing to get the specific cell (Column) in the row
    }
    
    public void add(int key) {
         int row=hashBucket(key);
         int column=hashBucketItems(key);
         if(matrix[row]==null) 
         {
             matrix[row]=new boolean[bucketItems]; // adding columns to that specific row
         }
        matrix[row][column]=true;
        
    }
    
    public void remove(int key) {
         int row=hashBucket(key);
         int column=hashBucketItems(key);
         if(matrix[row]!=null)
         {
            matrix[row][column]=false;   // removing value from the specific row
         }
       
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
         int row=hashBucket(key);
         int column=hashBucketItems(key);
         if(matrix[row]!=null)
         {
            return matrix[row][column]; 
             
         }
      return false;  // If row is null then there is no column to contain the key so return false
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */