// Time Complexity : O(1) for add, remove and contains
// Space Complexity : O(1) but constructor space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] storage;
    int firstHashing;
    int secondHashing;
    
    public MyHashSet() {
        this.firstHashing=1000;
        this.secondHashing=1000;
        this.storage=new boolean[firstHashing][];
    }
    public int firstHash(int key){
        return key%1000;
    }
    
    public int secondHash(int key){
        return key/1000;
    }
    
    public void add(int key) {
        if(storage[firstHash(key)]==null){
            if(firstHash(key)==0)
                //The size of second array would be 10001 since teh range is from 0 and not from 1
                storage[firstHash(key)]= new boolean[secondHashing+1];
            else
                storage[firstHash(key)]= new boolean[secondHashing];
        }
        storage[firstHash(key)][secondHash(key)]=true;
    }
    
    public void remove(int key) {
        if(storage[firstHash(key)]==null){
            return;
        }
        storage[firstHash(key)][secondHash(key)]=false;
    }
    
    public boolean contains(int key) {
        if(storage[firstHash(key)]==null){
            return false;
        }
        return storage[firstHash(key)][secondHash(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
