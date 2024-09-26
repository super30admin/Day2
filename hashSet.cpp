/*
TC: O(N/K), K - number of buckets
SC (extra space) : O(M) where M is number of values in the hashSet

*/


class MyHashSet {
public:
    /** Initialize your data structure here. */
    
    vector<vector<int>> hshSet;
    
    
    MyHashSet() {
        hshSet.resize(100);    
    }
    
    void add(int key) {
        
        int bucket = key%100;
        
        for(int i=0; i<hshSet[bucket].size(); i++){
            if(hshSet[bucket][i] == key)
                return;
        }

        
        hshSet[bucket].push_back(key);
        
    }
    
    void remove(int key) {
        
        int bucket = key%100;
        
        for(int i = 0; i<hshSet[bucket].size(); i++)
            if(hshSet[bucket][i] == key){
                hshSet[bucket].erase(hshSet[bucket].begin() + i);
                return;
            }

    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        
        int bucket = key%100;
                
        for(int i = 0; i<hshSet[bucket].size(); i++)
            if(hshSet[bucket][i] == key)
                return true;
        
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