// Time complexity: Amortized O(1) for search
// Space complexity: O(n) where n is the number of unique keys
// Code executed succesfully in leetcode
// Approach:
//Used linear chaining to avoid collisions. Used a vector of pairs to store keys and values.



class MyHashMap {
private: 
    vector<list<pair<int, int>>> table; 
    int size; 

    int hash(int key){
        return key % size;
    }

public:
    MyHashMap() {
        size = 1000000;
        table.resize(size);
    }
    
    void put(int key, int value) {
        int index = hash(key);
        for(auto& pair : table[index]){
            if(pair.first == key){
                pair.second = value;
                return;
            }
        }
        table[index].emplace_back(key, value);
    }
    
    int get(int key) {
        int index = hash(key);
        for(auto& pair : table[index]){
            if(pair.first == key){
                return pair.second;
            }
        }
        return -1;
    }
    
    void remove(int key) {
        int index = hash(key);
        for(auto it = table[index].begin(); it != table[index].end(); it++){
            if(it -> first == key){
                table[index].erase(it);
                return;
            }
        }
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */