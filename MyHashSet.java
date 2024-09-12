//Time Complexity: O(1)
//Space complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Bucket {
    /** Each bucket should be able to hold 1000000/16 elements = 62500**/
    public Integer[] element;
    public Bucket(){
        element = new Integer[62500];
    }

    //We should generate a hash code to check at which index we need to insert the value
    public int hashcode(int key){
        return key/16;
    }

    public void insertKey(int key){
        int index = hashcode(key);
        element[index] = key;
    }

    public void removeKey(int key){
        int index = hashcode(key);
        element[index] = null;
    }

    public boolean getKey(int key){
        int index = hashcode(key);
        if(element[index] ==  null)
            return false;
        return true;
    }

}


class MyHashSet {

    /** Initialize your data structure here. */
    private Bucket[] bucket;
    public MyHashSet() {
        bucket = new Bucket[16];
    }

    //To calculate which bucket it goes into
    public int bucketId(int key){
        return key%16;
    }

    public void add(int key) {
        int id = bucketId(key);
        if(bucket[id]==null)
            bucket[id] = new Bucket();
        bucket[id].insertKey(key);
    }

    public void remove(int key) {
        int id = bucketId(key);
        if(contains(key))
            bucket[id].removeKey(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int id = bucketId(key);
        return bucket[id] != null && bucket[id].getKey(key);
    }

    public static void main(String[] args){
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.remove(19);
        boolean param_3 = obj.contains(1);
    }
}

