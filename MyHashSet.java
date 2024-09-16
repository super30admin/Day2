// Time Complexity : O(1)
// Space Complexity : O(N^2) or O(key)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Implemented using Double Hashing
class MyHashSet {

    int H1 = 1001; 
    int H2 = 1000;
    boolean arr[][];
    public int hash1(int key){ //hash fn 1
        return key/H2;
    }
    public int hash2(int key){ //hash fn 2
        return key%H2;
    }
    
    public MyHashSet() {
        arr =  new boolean[H1][];
    }
    
    public void add(int key) {
        int h1 = hash1(key);    //claculating hash value for the input key
        int h2 = hash2(key);
        if(!contains(key)){
            if(arr[h1] == null){       
            arr[h1] = new boolean[H2];
            }
            arr[h1][h2] = true;     //based on the hash value going to that array and making it boolean true in evidence                                     //that element is added there.
        }
    }
    
    public void remove(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if(contains(key)){
                 arr[h1][h2] = false;

        }
    }
    
    public boolean contains(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if(arr[h1] == null)
            return false;
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