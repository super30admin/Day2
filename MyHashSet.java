// Time Complexity : 
    // remove() - o(1)
    // contains() - o(1)
    // add() - o(n) as we might have to intialize bucklist array
    //         o(1) avrage time as we have read heavy operations and will be adding values relatively less
// Space Complexity : o(n) where n is the total unique values expected in the input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] hashSet;
    int hashCode;
    int bucketHashCode;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashCode = 1000;
        bucketHashCode = 1000;
        
        hashSet = new boolean[1000][];
    }
    
    public void add(int key) {
        if(hashSet[key%hashCode] == null){
            if((key%hashCode) == 0) {
                hashSet[(key%hashCode)] = new boolean[bucketHashCode + 1];
            }
            else {
                hashSet[(key%hashCode)] = new boolean[bucketHashCode];
            }
        }
        hashSet[(key%hashCode)][(key/bucketHashCode)] = true;
    }
    
    public void remove(int key) {
        if(hashSet[key%hashCode] == null) return;
        hashSet[key%hashCode][key/bucketHashCode] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(hashSet[key%hashCode] == null) return false;
        return hashSet[key%hashCode][key/bucketHashCode];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */