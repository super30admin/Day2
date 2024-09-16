// Time Complexity :  O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// any suggentions for avoiding filling the array below ? I think that is slowing this down since it will itrate over whole array to set it to -1.
// without that getting wrong answer.

import java.util.*;
class MyHashMap {
    
    int[][] hashMap;
    int size;

    public MyHashMap() {
        size=1000;
        hashMap = new int[size][];
    }
    
    public int hash1(int key){
        return key%size;
    }
    
    public int hash2(int key){
        return key/size;
    }
    
    public void put(int key, int value) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if( hashMap[hash1] == null){
            if(hash1==0){
                hashMap[hash1] = new int[size+1];
            }
            else{
                hashMap[hash1] = new int[size];
            }
            Arrays.fill(hashMap[hash1],-1);
        }
        hashMap[hash1][hash2] = value;
    }
    
    public int get(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        return (hashMap[hash1] == null) ? -1 : hashMap[hash1][hash2];
    }
    
    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(hashMap[hash1] != null){
            hashMap[hash1][hash2] = -1;
        }
    }
}
