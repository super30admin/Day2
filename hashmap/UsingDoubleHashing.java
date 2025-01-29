// Time Complexity : all method have complexity of O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes the 1000 idex issue

package hashmap;

class UsingDoubleHashing {

    public static void main(String[] args) {
        UsingDoubleHashing hashMap = new UsingDoubleHashing();
        System.out.println(hashMap.get(101));
        hashMap.put(101, 121);
        hashMap.put(100101, 122);
        hashMap.put(200101, 122);

        System.out.println(hashMap.get(101));
        System.out.println(hashMap.get(100101));
        System.out.println(hashMap.get(200101));
        hashMap.remove(101);
        System.out.println(hashMap.get(101));
        System.out.println(hashMap.get(200101));
//        hashMap.test();

    }


    private int[][] storage;

    public UsingDoubleHashing() {
        this.storage = new int[1000][];
    }

    private int hashIdx(int key) {
        return key % 1000;
    }

    private int getSubBucket(int key) {
        return key / 1000;
    }

    public void put(int key, int value) {

        int idx = hashIdx(key);

        if (storage[idx] == null) {

            // edge case
            if (idx == 0) {
                storage[idx] = new int[1000 + 1];
            } else {
                storage[idx] = new int[1000];
            }

            // Edge case
            //Only edge case it is failing is that 0 is default value of initialized arr. Fill the initial nested array with -1; So that value give in not for a key not in the hashMap. If a key is not in hashMap. it will give -1
            Arrays.fill(storage[idx], -1);
        }

        int subBucketKey = getSubBucket(key);
        storage[idx][subBucketKey] = value;
    }

    public int get(int key) {
        int idx = hashIdx(key);

        if (storage[idx] == null) {
            return -1;
        }

        int subBucketKey = getSubBucket(key);

        return storage[idx][subBucketKey];
    }

    public void remove(int key) {
        int idx = hashIdx(key);

        if (storage[idx] == null) {
            return;
        }

        int subBucketKey = getSubBucket(key);

        storage[idx][subBucketKey] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
