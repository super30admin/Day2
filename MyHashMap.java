import java.util.*;
// Time Complexity : O(1) for all the operations - get, put, remove.
// Space Complexity : O(n^2) space complexity. there are other ways like using linked list in order to reduce the space complexity but thats not efficient in terms of time complexity.
// Did this code successfully run on Leetcode : yes, I did run.
// Any problem you faced while coding this : Not much, because i followed the same approach that was explained in class for hashset implementation.


// Your code here along with comments explaining your approach

class MyHashMap {
    //I took the array of lists.
    List<Integer>[] hashMap;
    //I took the square root of the maximum limit in the constraints, so I took the 10^3 as the size for the static array.
    int capacity = 1000;
    //but for the inner dynamic list we need one extra capacity since the constraints are 0<=key<=10^6, 10^6 and 0 will collide, so we use one extra space.
    int mapCapacity = 1001;
    public MyHashMap() {
        hashMap = new ArrayList[capacity];
    }
    //returns the hash of the key : index of the outer array.
    private int hash(int key)
    {
        return key%capacity;
    }
    //returns the hash of the key : index of the inner list.
    private int mapHash(int key)
    {
        return key/mapCapacity;
    }
    //this method adds the value into the inner list by finding the indexes of both inner and outer arrays using the different hash functions.
    public void put(int key, int value) {
        int index = hash(key);
        if(hashMap[index] == null)
            hashMap[index] = new ArrayList<>(Collections.nCopies(mapCapacity, -1));

        int mapIndex = mapHash(key);
        hashMap[index].set(mapIndex, value);
    }
    //this method returns the value if the key is already present otherwise it returns -1.
    public int get(int key) {
        int index = hash(key);
        if(hashMap[index] == null) return -1;
        List<Integer> res = hashMap[index];
        int mapIndex = mapHash(key);
        return res.get(mapIndex);
    }
    //this method remove sthe value for the key into -1, that way we remove the value associated with the key.
    public void remove(int key) {
        int index = hash(key);
        if(hashMap[index] == null) return;
        List<Integer> res = hashMap[index];
        int mapIndex = mapHash(key);
        res.set(mapIndex, -1);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */