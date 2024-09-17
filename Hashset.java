// Time Complexity :
//Add : O(1) as adding to an array is constant time
//Remove : O(1)
//Contains : O(1)

// Space Complexity : O[mn] where m and n are the row and column of the boolean matrix

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this :
//I did the same hashcode function initially for finding row and column. This resulted in collision.
//Remember to do a % , followed by a /


// Your code here along with comments explaining your approach
class HashSet {

    int buckets = 1000; //first row
    int bucketItems = 1000; //nested array

    //boolean matrix for double hashing
    boolean[][] hashset = new boolean[buckets][]; //we keep the columns uninitialized in order to avoid memory wastage.

    //Use key%buckets to get the bucket
    public int bucket(int key){
        return key%buckets;
    }

    //Use key/bucketItems to get the bucketItem
    public int bucketItem(int key){
        return key/bucketItems;
    }
    /** Initialize your data structure here. */
    public HashSet() {

    }

    public void add(int key) {

        int bucket = bucket(key);   //find the row number
        int bucketItem = bucketItem(key); // find the column number

        if(hashset[bucket] == null){ // if no element is present in that bucket, first create a new array for the elements to come
            hashset[bucket] = new boolean[bucketItems];
        }

        hashset[bucket][bucketItem] = true; // the element is set to true to indicate the presence

    }

    public void remove(int key) {

        int bucket = bucket(key);
        int bucketItem = bucketItem(key);

        if(hashset[bucket]== null) //if no array is initialized at that index, the element is not going to be in the column.
            return ;

        hashset[bucket][bucketItem] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(hashset[bucket]== null) //if no array is formed at that index, the matrix does not contain the element
            return false;
        return hashset[bucket][bucketItem];

    }
}

class Main{
    public static void main(String[] args){
        HashSet obj = new HashSet();
        int key =10;
        obj.add(key);
        obj.remove(key);
        boolean param_3 = obj.contains(key);
        System.out.println(key+" is present : "+param_3);


        key =100;
        obj.add(key);
        param_3 = obj.contains(key);
        System.out.println(key+" is present : "+param_3);
    }


}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */