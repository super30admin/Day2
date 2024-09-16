// Time Complexity :O(1)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


public class MyHashSet {
    private boolean[][] storage; 
    private int buckets;
    private int bucketItems;

    //Constructor to Initialize the MyHashSet
    public MyHashSet(){
        buckets = 1001;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    //Getting an Index value of a bucket in an array
    private int bucket(int key){
        return key / buckets;
    }

    //Getting an index value of item where it is stored in an array
    private int bucketItem(int key){
        return key % bucketItems;
    }

    //To add an item into the hash set,
    //we are implementing a hash function to get bucket in which the value has to be indexed
    //then calling other hash function to check where data has to be stored
    //if there is no bucket created previouly in the indexed location we create a new bucket and the add 
    //boolean value to that particular location else update the value in already existing bucket
    public void add(int key){
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            storage[bucket] = new boolean[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }

    //To remove an iten from hash set, call both hash function to get indexed value as well as location data
    //if the indexed value is null the just return
    //else if the value is present, update value to false
    public void remove(int key){
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem] = false;
    }

    //To check if item  is in hash set or not, call both hash function to get indexed value as well as location data
    //if the indexed value is null the just return false
    //else return value from storage[bucket][bucketItem]
    public boolean contains(int key){
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketItem];
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
