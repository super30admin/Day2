// Double hashing technique on HashMap
// Time Complexity : PUT, GET, REMOVE - O(1)
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Arrays;
class MyHashMap {
    int[][] map;
    int bucketSize = 1000;
    int bucketItemSize = 1000;
    public MyHashMap() {
        map = new int[bucketSize][];
    }

    public void put(int key, int value) {
        int bucketIndex = bucketIndex(key);
        int[] currItemBucket = map[bucketIndex];
        if(currItemBucket == null) {
            map[bucketIndex] = new int[bucketIndex == 0 ? bucketItemSize+1 : bucketItemSize];
            Arrays.fill(map[bucketIndex], -1);
        }
        int bucketItemIndex = bucketItemIndex(key);
        map[bucketIndex][bucketItemIndex] = value;
    }

    public int get(int key) {
        int bucketIndex = bucketIndex(key);
        int[] currItemBucket = map[bucketIndex];
        if(currItemBucket == null) return -1;
        int bucketItemIndex = bucketItemIndex(key);
        return map[bucketIndex][bucketItemIndex];
    }

    public int bucketIndex(int key) {
        return key%bucketSize;
    }

    public int bucketItemIndex(int key) {
        return key/bucketSize;
    }

    public void remove(int key) {
        int bucketIndex = bucketIndex(key);
        int[] currItemBucket = map[bucketIndex];
        if(currItemBucket == null) return;
        int bucketItemIndex = bucketItemIndex(key);
        if(map[bucketIndex][bucketItemIndex] != -1)  map[bucketIndex][bucketItemIndex] = -1;
    }

    public static void main(String args[]) {
        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        obj.put(1,2);
        obj.put(2,2);
        System.out.println(obj.get(1));
        obj.remove(1);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
