// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : The understanding of the matrix was hard to get.


/**
 * Implemented hashmap using List inside a list. essentially 1001*1000 matrix.
 * The main list contains a series of buckets. each bucket is also a list.
 * Hashing function of 10^3 is used. 
 */
import java.util.ArrayList;
import java.util.List;

class MyHashMap {
    List<int[]>[] list;

    public MyHashMap() {
        list = new List[1001];// the edge case of 10^6
        for (int i = 0; i < 1001; i++) {
            list[i] = new ArrayList<>();
        }
    }
    
    public void put(int key, int value) {
        int hash = key%1000;
        List<int[]> bucket =list[hash];
        for(int[] element: bucket) {
            if(element[0]== key) {
                element[1] = value;
                return;
            }
        }
        bucket.add(new int[]{key, value});
    }
    
    public int get(int key) {
        int hash = key%1000;
        List<int[]> bucket = list[hash];
        for(int[] element: bucket) {
            if(element[0]== key) {
                return element[1];
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = key % 1000;
        List<int[]> bucket = list[hash];
        for(int i=0;i< bucket.size();i++) {
            if(bucket.get(i)[0]== key) {
                bucket.remove(i);
            }
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */