/* Code is submitted succesfully on Leetcode
Hash Set with hash function and bucket size = 1000. 
Using Double Hashing with boolean arrays
*/

class MyHashSet {

    /** Initialize your data structure here. */
    //Taking Boolean Array
    //The trick is to create 1000 of each buckets 
    //ArrayList<ArrayList<Boolean>> hashset = new ArrayList<ArrayList<Boolean>>(1000);
    
    int num_buckets = 1000;
    int bucket_size = 1000;
    
    //Creating Hash Set with number of buckets = 1000
    boolean [][] hs = new boolean [num_buckets][];
    
    public MyHashSet() {
    }
    
    private int hash1(int key){
        return (key % 1000);
    }
    
    private int hash2(int key){
        return (key / 1000);
    }
    
    public void add(int key) {
        if(hs[hash1(key)] == null){
            hs[hash1(key)] = new boolean[bucket_size];
            hs[hash1(key)][hash2(key)] = true;
        }else{
            //Double Hashing (Collision Occurs)
            hs[hash1(key)][hash2(key)] = true;
        }
    }
    
    public void remove(int key) {
        if(hs[hash1(key)] != null){
            hs[hash1(key)][hash2(key)] = false;
        }
    }
        
    
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(hs[hash1(key)] != null){
            return (hs[hash1(key)][hash2(key)]);
        }
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
