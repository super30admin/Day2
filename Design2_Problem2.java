
// Time Complexity : Push, Pop, getMin() : O(1)
// Space Complexity : Best : O(N) Worst : O(10^6)


// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/*
Range of elements is let's suppose 1 to 1000000 (1 Million)
created boolean 2D array and initialized only primary array(Outer dimension) as of now. We will initialize inner dimension whenever needed.
Used Double hasing here to calculate the index for the key.

To insert, delete and update : Calculate hash1 and hash2. 
If in boolean array is null --> Initialized the boolean array of size bucketItems and if hash1 is 0, initialize of size 1001 to store 1000000 at index 0.

Then after just set the value true at storage[h1][h2]. 

For remove() : Set false at storage[h1][h2];

For contains() : Just return the value of storage[h1][h2].

*/



class MyHashSet {
    private int buckets = 1000;
    private int bucketItems = 1000;
    boolean[][] storage;
    public MyHashSet() {
        storage = new boolean[buckets][];
    }

    public int hash1(int key){
        return key % buckets;
    }
    
    public int hash2(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);

        if(storage[h1] == null){
            if(h1 == 0){
                storage[h1] = new boolean[bucketItems + 1];
            }
            else{
                storage[h1] = new boolean[bucketItems];
            }
        }
        storage[h1][h2] = true;

    }
    
    public void remove(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if(storage[h1] == null) { 
            return;
        }

        storage[h1][h2] = false;
    }
    
    public boolean contains(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        
        if(storage[h1] == null) {
            return false;
        }
        return storage[h1][h2]; 

    }
    
}

public class Design2_Problem2{
    public static void main(String args[]){
        MyHashSet set = new MyHashSet();
        set.add(1); set.add(2); 
        
        System.out.println("Set.contains() : " + set.contains(1));
        System.out.println("Set.contains() : " + set.contains(3));
        set.add(2); 
        
        System.out.println("Set.contains() : " + set.contains(2));
        set.remove(2);

        System.out.println("Set.contains() : " + set.contains(2));

    }
}

