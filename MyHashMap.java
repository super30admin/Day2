// Time Complexity : put O(1), get O(1), remove O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Used double hashing technique here. 
 * Used 2 hash functions for double hashing.
 * Created a Pair class that has key and value.
 * Created a 2D array of Pair. By finding the 2 hash functions find the location. 
 * For adding element, check if the first index pointer is not null, if null then create an array there, find second index and add element there.
 * For getting and removing, find the exact location using hash functions.
 *
 */
class MyHashMap {
    int bucketsize;
    int insidebucketsize;
    Pair[][] map;

    class Pair{
        int key;
        int value;

        Pair(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    public MyHashMap() {
        bucketsize=1000;
        insidebucketsize=1000;
        map=new Pair[bucketsize][];
    }

    private int hash1(int key){
        return key%bucketsize;
    }

    private int hash2(int key){
        return key/insidebucketsize;
    }
    
    public void put(int key, int value) {
        int idx=hash1(key);
        if(map[idx]==null){
            if(idx==0){
                map[idx]=new Pair[insidebucketsize+1];
            }else{
               map[idx]=new Pair[insidebucketsize]; 
            }
        }
        int insideidx=hash2(key);
        map[idx][insideidx]=new Pair(key,value);
    }
    
    public int get(int key) {
        int idx=hash1(key);
        int insideidx=hash2(key);
        if(map[idx]==null || map[idx][insideidx]==null){
            return -1;
        }
        return map[idx][insideidx].value;
    }
    
    public void remove(int key) {
        int idx=hash1(key);
        int insideidx=hash2(key);
        if(map[idx]!=null && map[idx][insideidx]!=null){
            map[idx][insideidx]=null;
        }
    }
    
 // Driver code 
    public static void main(String[] args) 
    { 

	// MyHashMap object will be instantiated and called as such:
	    MyHashMap obj = new MyHashMap();
	    obj.put(10000,0);
	    int param_2 = obj.get(key);
	    obj.remove(key);
    } 
}
