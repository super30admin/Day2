// Time Complexity : O(1), we hash the key value and directly get index of both arrays
// Space Complexity : O(1), fixed to input range, we optimise by allocation memory on-demand
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
#include<iostream>

using namespace std;

class MyHashSet {
public:
    bool *hash[1000]={NULL};
    /** Initialize your data structure here. */
    MyHashSet() {  
    }
    
    void add(int key) {
        int idx;
        idx = key%1000;
        if(hash[idx]==NULL){
            if(idx==0){
                hash[idx] = new bool[1001]();
            } else {
                hash[idx] = new bool[1000]();
            }
        }
        int arridx = key/1000;
        *(hash[idx]+arridx) = true;
        
    }
    
    void remove(int key) {
        int idx = key%1000;
        if(hash[idx] != NULL){
            int arridx = key/1000;
            *(hash[idx]+arridx) = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int idx = key%1000;
        if(hash[idx] != NULL){
            int arridx = key/1000;
            return *(hash[idx]+arridx);
        }
        return false;
    }
};