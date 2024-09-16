//Time Complexity : O(1) 
//Space Complexity : O(n)
// It did run successfully on Leetcode
// Problems :  Understanding why we are taking 1001 rather than taking 1000 for buckets


/*
As we are supposed to just implement contain function, we have implementing a 
boolean maxtrix (Not always a matrix)
While adding the element, we'll me marking that index true and the opposite while
removing the element.

*/


class MyHashSet {

   
    int buckets;
    int bucketItems;
    boolean[][] exist;
    public MyHashSet() {
        buckets = 1001;
        bucketItems = 1000;
        exist = new boolean[buckets][];
    }

    public void add(int key) {
        int bucketNo = key%buckets;
        int bucketItemNo=key/bucketItems;
        if(exist[bucketNo]==null)
        {
            exist[bucketNo] =new boolean[bucketItems];
        }
        exist[bucketNo][bucketItemNo] = true;
    }

    public void remove(int key) {
        int bucketNo = key%buckets;
        int bucketItemNo = key/bucketItems;
        if(exist[bucketNo]==null)return;
        else
        {
            exist[bucketNo][bucketItemNo] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketNo = key%buckets;
        int bucketItemNo = key/bucketItems;
        if(exist[bucketNo]!=null)
        {
            return (exist[bucketNo][bucketItemNo]);
        }
        return false;
    }
}

