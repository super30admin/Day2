// The HashMap is implemented using a vector of vectors, where each vector represents a row (bucket) in the hash table.
// In the worst case, all keys hash to the same index, resulting in a linear search within that bucket for operations like put, get, and remove, leading to O(n) time complexity.
// The space complexity is determined by the number of keys and the unique indices after hashing, resulting in O(N + M) space complexity.
#include<bits/stdc++.h>
using namespace std;
class MyHashMap {
    vector<vector<pair<int,int>>> map;
    const int size =10000;
public:
    MyHashMap() {
        map.resize(size);
    }
    
    void put(int key, int value) {
        int index = key % size;
        vector<pair<int,int>> &row = map[index];
        for(auto iter=row.begin(); iter!=row.end();iter++){
            if(iter->first==key){
                iter->second=value;
                return;
            }
        }
        row.push_back(make_pair(key,value));
    }
    
    int get(int key) {
        int index = key%size;
        vector<pair<int,int>> &row = map[index];
        for(auto iter=row.begin();iter!=row.end();iter++){
            if(iter->first==key){
                return iter->second;
            }
        }
        return -1;
    }
    
    void remove(int key) {
        int index=key%size;
        vector<pair<int,int>> &row = map[index];
        for(auto iter=row.begin(); iter!=row.end();iter++){
            if(iter->first==key){
                row.erase(iter);
                return;
            }
        }
    }
};