/*
Time Complexity : O(N/k) where N is the total elements and k is the no of buckets
Spaced Complexity: O(K + N) k is the no of bucks and K is the unique elements inserted 


logic: 
Same logic as design_hashmap.

*/




class MyHashSet {
    
private: 
    vector<vector<int>>map;
    int size = 10000;
public:
    /** Initialize your data structure here. */
    
    MyHashSet() {
        map.resize(size);
        
    }
    
    void add(int key) {
        int bucket = key % size;
        for(int i = 0; i < map[bucket].size();i++){
            if(map[bucket][i]==key)return;
            
        }
        map[bucket].push_back(key);
        
        
    }
    
    void remove(int key) {
        int bucket = key % size;
        for(int i = 0; i < map[bucket].size();i++){
            if(map[bucket][i]==key){
                map[bucket].erase(map[bucket].begin() + i);
                return;
            }
        }        
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int bucket = key % size;
        for(int i = 0; i < map[bucket].size();i++){
            if(map[bucket][i]==key)return true;
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