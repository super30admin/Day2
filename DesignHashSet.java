// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
       /* Runtime: 12 ms, faster than 97.88% of Java online submissions for Design HashSet.
        Memory Usage: 54 MB, less than 77.78% of Java online submissions for Design HashSet.*/
// Any problem you faced while coding this :


 /* - Initialised 2d array
    - locations of axis-1 calcuated using key % 1000 and for axis-2 by using key /1000
    - Now addition of elements : placed according to hash calcuation, but verified a condition to check for non-initialised columns
    - similarly for removing elements (by def in java if position isn't occupied it remians in flase state), so if element is available at loc then it's changed to False
    - Contians check : check for boolen state at [][] */

class DesignHashSet {

boolean store[][];
int buckets =1000;
int bucketItems =1000;


    public DesignHashSet() {
        store = new boolean[buckets][];
}


private int bucket(int key){
    return key % buckets;
}

private int bucketitem(int key){
    return key / bucketItems;
}

public void add(int key) {
    int bucket = bucket(key);
    int bucketItem = bucketitem(key);

    if(store[bucket]==null){
        store[bucket] = new boolean[bucketItems];
    }
    store[bucket][bucketItem] = true;


    
}

public void remove(int key) {
    int bucket = bucket(key);
    int bucketItem = bucketitem(key);

    if(store[bucket]!=null){
        store[bucket][bucketItem] = false;
    }
}

/** Returns true if this set contains the specified element */
public boolean contains(int key) {
    int bucket = bucket(key);
    int bucketItem = bucketitem(key);
    
    return store[bucket] != null && store[bucket][bucketItem]==true ;
}

public static void main(String args[]){

    DesignHashSet Dhm = new DesignHashSet();
    Dhm.add(2);
    //Dhm.add(2);
    Dhm.contains(2);
    Dhm.remove(2);
   // Dhm.remove(2);
    Dhm.contains(2);



}
}

/**
* Your MyHashSet object will be instantiated and called as such:
* MyHashSet obj = new MyHashSet();
* obj.add(key);
* obj.remove(key);
* boolean param_3 = obj.contains(key);
*/