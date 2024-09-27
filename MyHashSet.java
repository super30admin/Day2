// Time Complexity : O(1) amortized for each operation
// Space Complexity : )(n) where n is max size of hashset
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : only for handling out of bound

public class MyHashSet{
    int bucket = 1000;
    int bucketItems = 1000;
    boolean set[][] = new boolean[1000][]; // will make 1000 x 1000 matrix in worst case
    //boolean because we can calculate the value back from its location
    public MyHashSet() {
    }
    
    public int bucketLocation(int x){
        return  x % bucket;
    }
    public int arrayInBucketLocation(int x){
        return x / bucket;
    }
    public void add(int key) {
        int bucket = bucketLocation(key);
        int bucketItemLocation = arrayInBucketLocation(key);
        if(set[bucket] == null)
        {
            set[bucket] = new boolean[bucketItems];// if that location is empty we will initialize it with another array
        }
        set[bucket][bucketItemLocation] = true;// put true at that location
    }
    
    public void remove(int key) {
        int bucket = bucketLocation(key);
        int bucketItemLocation = arrayInBucketLocation(key);
        if(set[bucket] != null){
            set[bucket][bucketItemLocation] = false;// for removal just put false
        }

    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucketLocation(key);
        int bucketItemLocation = arrayInBucketLocation(key);
        return set[bucket] != null && set[bucket][bucketItemLocation];// if null false(not present) if not go to location and check if t or f
        
    }

    public static void main(String args[]){
        MyHashSet obj = new MyHashSet();
        obj.add(2);
        obj.add(2002);
        obj.add(3002);
        obj.add(400);
        obj.add(999999);
        System.out.println("contains(999999) " + obj.contains(999999));
        obj.remove(999999);
        System.out.println("After reoving - contains(999999) " + obj.contains(999999));
    }
}