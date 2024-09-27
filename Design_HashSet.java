// Time Complexity :  For contains add and remove all will have O(k/n) where n -> number of elements in the main list and k -> number of collided elements . This is because every function calls contains internally

// another way is to think that if all the keys of the main list were required, we would take O(k) but since we have collisions so we will not take upall of them and hence O(k/n)

// Space Complexity : O(m+k) where m is the number of unique keys that are used and k is the number of collisions that occur
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Bucket {
    // bucket class which will store the list of all the elements which have the
    // same hashed key value
    private List<Integer> bucket;

    public Bucket() {
        this.bucket = new LinkedList<Integer>();
    }

    public boolean contains(Integer val) {
        // check if value is already present
        for (Integer i : this.bucket) {
            if (i.equals(val))
                return true;
        }
        return false;
    }

    public void add(Integer val) {
        // add if the value is not present
        if (this.bucket.contains(val))
            return;
        this.bucket.add(val);
    }

    public void remove(Integer val) {
        // remove if the value is not present
        if (this.bucket.contains(val))
            this.bucket.remove(val);

    }

}

class MyHashSet {

    private int k;
    private List<Bucket> bucket_list;

    /** Initialize your data structure here. */
    public MyHashSet() {
        // initialise the list of bucket as well as the start of each bucket and prime
        // number k
        this.k = 2003;
        this.bucket_list = new ArrayList<Bucket>();

        for (int i = 0; i < k; i++) {
            this.bucket_list.add(new Bucket());
        }
    }

    public void add(int key) {
        // creates a hashed key and adds the integer to the corresponding bucket
        int hash = key % k;
        bucket_list.get(hash).add(key);

    }

    public void remove(int key) {
        // creates a hashed key and removes the integer to the corresponding bucket
        int hash = key % k;
        bucket_list.get(hash).remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        // creates a hashed key and checks if the integer to the corresponding bucket
        int hash = key % k;
        return bucket_list.get(hash).contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */