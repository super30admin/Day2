// Time Complexity : O(1) all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
class MyHashMap {
    int[][] map;
    int bucket;

    public MyHashMap() {
        bucket = 1001;
        map = new int[bucket][];
    }
    
    public void put(int key, int value) {
        int i = hash(key);
        int j = hash1(key);
        if(map[i]==null) {
            map[i] = new int[bucket]; 
            Arrays.fill(map[i],-1);
        }
        map[i][j]=value;
    }
    
    public int get(int key) {
        int i = hash(key);
        int j = hash1(key);
        if(map[i]!=null) {
            return map[i][j];
        }
        return -1;
    }
    
    public void remove(int key) {
        int i = hash(key);
        int j = hash1(key);
        if(map[i]!=null) {
            map[i][j]=-1;
        }
    }
    
    public int hash(int key) {
        return key%bucket;
    }
    public int hash1(int key) {
        return key/bucket;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */