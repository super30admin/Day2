// Time Complexity : All operation are O(1) as we are using O(n) space
// Space Complexity : O(n) as we are using double hashing technique with one unique space for every input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {

    /** Initialize your data structure here. */
    boolean[][] arr;
    public MyHashSet() {
        arr = new boolean[1000][];
    }

    public int bucket(int key){
        return key%1000;
    }

    public int bucketItem(int key){
        return key/1000;
    }

    public void add(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(arr[bucket]==null){
            if(bucket==0){
                arr[bucket] = new boolean[1001];
            } else {
                arr[bucket] = new boolean[1000];
            }
        }
        arr[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(arr[bucket]==null) return;
        arr[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(arr[bucket]==null) return false;
        return arr[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */