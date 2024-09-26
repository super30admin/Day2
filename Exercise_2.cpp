// Time Complexity                                  : Add - O(1), 
//                                                    Remove - O(1), 
//                                                    Contains - O(1)
//
// Space Complexity                                 : O(2*N) = O(N)
// Did this code successfully run on Leetcode       : Yes.
// Any problem you faced while coding this          : No.

#include <bits/stdc++.h>
using namespace std;

class MyHashSet {
public:
    int p = 1000;
    bool mp[1001][1001];
    MyHashSet() {
        memset(mp,false,sizeof(mp));
    }
    
    pair<int,int> getPrimaryAndSecondaryIndex(int key) {
        int pa = key%p;
        int sa = key/p;
        return {pa,sa};
    }
    
    void add(int key) {
        auto [pa, sa] = getPrimaryAndSecondaryIndex(key);
        if(!mp[pa][sa]) mp[pa][sa] = true;
    }
    
    void remove(int key) {
        auto [pa, sa] = getPrimaryAndSecondaryIndex(key);
        mp[pa][sa] = false;
    }
    
    bool contains(int key) {
        auto [pa, sa] = getPrimaryAndSecondaryIndex(key);
        return mp[pa][sa];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */