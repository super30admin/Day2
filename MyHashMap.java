import java.util.Arrays;

// Time Complexity : 0(1) all operations are order of 1 
// Space Complexity : o(n)?? not sure 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
    int bucket;
    int[][] hashMap;
    
    public MyHashMap() {
        this.bucket = 1000;
        this.hashMap = new int[bucket][];
    }
    
    public void put(int key, int value) {
        
        int i = hash1(key);
        int j = hash2(key);
        if( hashMap[i] == null){
        if(i==0){
            hashMap[i] = new int[bucket+1];
        }
        else{
            hashMap[i] = new int[bucket];
            }
        Arrays.fill(hashMap[i],-1);
        }
        hashMap[i][j] = value;
    }
    
    public int get(int key) {
        int i = hash1(key);
        int j = hash2(key);
        if(hashMap[i]!=null) {
            return hashMap[i][j];
        }
        return -1;  
    }
    
    public void remove(int key) {
        int i = hash1(key);
        int j = hash2(key);
        if(hashMap[i]!=null) 
             hashMap[i][j] = -1;
    }
    
    
    public int hash1(int key) {
        return key%bucket;
    }
    
    public int hash2(int key) {
        return key/bucket;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */