// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {

    class HashValue {
        int val;

        public int getVal(){
            return val;
        }

        public void setVal(int val){
            this.val = val;
        }
    }

    HashValue[][] storage;
    int bucketSize;
    int bucketItemsSize;

    public MyHashMap() {
        bucketSize = 1000;
        bucketItemsSize = 1000;
        storage = new HashValue[bucketSize][];
    }

    public int getBucket(int key){
        return key % bucketSize;
    }

    public int getBucketItem(int key){
        return key / bucketItemsSize;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(storage[bucket] == null){
            if(bucket == 0)
                storage[bucket] = new HashValue[bucketItemsSize + 1];
            else
                storage[bucket] = new HashValue[bucketItemsSize];
        }
        HashValue hv = new HashValue();
        hv.setVal(value);
        storage[bucket][bucketItem] = hv;
    }

    public int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(storage[bucket] == null || storage[bucket][bucketItem] == null)
            return -1;

        HashValue hv = storage[bucket][bucketItem];
        return hv.getVal();
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if(storage[bucket] == null || storage[bucket][bucketItem] == null)
            return;

        storage[bucket][bucketItem] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */