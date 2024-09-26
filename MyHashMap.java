// Time Complexity : O(1) for all operations
// Space Complexity : O(1) since no additional data structure is used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashMap {
    
    private int[][] hashMap;
    private int hash1(int key){
        return key % 1000;
    }
     private int hash2(int key){
        return key / 1000;
    }


    public MyHashMap() {
        //initialize only the index array the values array is initialized only if needed
        this.hashMap = new int[1000][];
    }
    
    public void put(int key, int value) {
        //if value array is not null for particuar has key then only for edge case index 1000000 intialize to 1001  others initialize to size 1000
        //and insert using hash1 and hash2 functions respectively
        //inserting value +1 for easy removal operation since values are positive only and 0 is used for removal to avoid initialization
        if(hashMap[hash1(key)] == null){
            if(key == 1000000){
                hashMap[hash1(key)] = new int[1001];
            
            }
            else{
            hashMap[hash1(key)] = new int[1000]; }
        }
       hashMap[hash1(key)][hash2(key)] = value+1;
                
    }
    
    public int get(int key) {

        if(hashMap[hash1(key)]!=null)
             return hashMap[hash1(key)][hash2(key)]-1;
        return -1;
    }
    
    public void remove(int key) {
        if(hashMap[hash1(key)]!=null && hashMap[hash1(key)][hash2(key)]!=0)
             hashMap[hash1(key)][hash2(key)] = 0;
    }
}



/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
