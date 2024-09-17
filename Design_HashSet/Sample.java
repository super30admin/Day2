// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * we 2D array here for keeping track of elements. First is primary array and to each location of primary array we have atttached another 1D array
 * The size of array is square root of upper bound of input and we use two hashing functions primary and secondary for determining the correct location for each element
 * primary function gives location in primary array and secondary function gives location in secondary array
 * for each operation we take primary and secondary location.
 * for add, first we check if secondary array is initialized for primary array index. if no we initialize it. If loc is zero then we allocate 1001 array size to cover all elements for index 0
 * else for all other locations we attach array of size 1000. 
 * if secondary array is already initialized or after initialized, we put true in location specified by secondary function
 * For remove, we check if secondary array is initialized, if yes we just put false in respective loc. If no, no need to do anything as element is not there and we can be sure of it
 * For contains, also we check if primary index has secondary array attached. If yes then we return value which is present in secondary array location
 * if secondary array is not initialized, then for sure element is not present in array so we return false 
*/



class MyHashSet {
    boolean[][] set;
    
    
    private int primary(int x){
        return x % 1000;
    }
    
    private int secondary(int x){
        return x / 1000;
    }
    
    public MyHashSet() {
        set = new boolean[1000][];
    }
    
    public void add(int key) {
        int first = primary(key);
        int sec = secondary(key);
        
        if(set[first] == null){
            if(first == 0){
                set[first] = new boolean[1000 + 1];
            }else{
                set[first] = new boolean[1000];
            }  
        }
        
         set[first][sec] = true;
    }
    
    public void remove(int key) {
        int first = primary(key);
        int sec = secondary(key);
        
        if(set[first] != null){
           set[first][sec] = false;  
        }
        
    }
    
    public boolean contains(int key) {
        int first = primary(key);
        int sec = secondary(key);
        
        if(set[first] == null)return false;
        
        return set[first][sec];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
