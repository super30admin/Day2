// Time Complexity : O(1), but internally its O(n) for add,delete,contians as we
//                     searching the bucket list.
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Still confused about implementation.

class Bucket{
    List<Integer> bucket;

    Bucket()
    {
        this.bucket = new LinkedList<Integer>();
    }

    public void addInBucket(Integer key){
        int index = bucket.indexOf(key);
        if(index == -1){
            bucket.add(key);
        }
    }

    public void deleteInBucket(Integer key){
        int index = bucket.indexOf(key);
        if(index != -1){
            bucket.remove(key);
        }
    }

    public boolean isPresent(int key){
        int index = bucket.indexOf(key);
        if(index != -1){
            return true;
        }
        return false;
    }

}
class MyHashSet {

    /** Initialize your data structure here. */
    List<Bucket> set;
    int modulo;
    public MyHashSet() {
        this.set = new ArrayList<Bucket>();
        this.modulo = 10000;// since the given constraint says that the number of operations will be in the range of [1, 10000].
        for(int i =0 ;i < modulo;i++)
        {
            set.add(new Bucket());
        }

    }

    public void add(int key) {
        int position = key % modulo;
        set.get(position).addInBucket(key);
    }

    public void remove(int key) {
        int position = key % modulo;
        set.get(position).deleteInBucket(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int position = key % modulo;
        return set.get(position).isPresent(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */