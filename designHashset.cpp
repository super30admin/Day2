// Time complexity add-> O(1),remove  and contains  O(1) amortized time can be O(n) in worst or very rare case
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


#include<iostream>
using namespace std;
#include<vector>
#include<stack>
#include<algorithm>

class MyHashSet {
public:
    /** Initialize your data structure here. */
    vector<vector<int>>buckets;
    int num_buckets;
    int buc_items;
    
    MyHashSet() {
        num_buckets=1000;
        buc_items=1000;
        buckets = vector<vector<int>>(num_buckets,vector<int>{});
        
    }
    int bucket(int key){
        return key % num_buckets;
    }
    int buc_item(int key){
        return key/ buc_items;
    }
    
    void add(int key) {
        int buck_pos = bucket(key);
        int bucket_item = buc_item(key);
        if(find(buckets[buck_pos].begin(),buckets[buck_pos].end(),key)== buckets[buck_pos].end())
            buckets[buck_pos].push_back(key);
   
        
    }
    
    void remove(int key) {
        int buck_pos = bucket(key);
        auto it = find(buckets[buck_pos].begin(),buckets[buck_pos].end(),key);
        if(it != buckets[buck_pos].end()){
            buckets[buck_pos].erase(it);
        }
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        
        int buck_pos = bucket(key);
        auto it = find(buckets[buck_pos].begin(),buckets[buck_pos].end(),key);
        if(it != buckets[buck_pos].end()){
            return true;
        }
        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */