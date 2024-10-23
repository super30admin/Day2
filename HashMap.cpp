// Time Complexity : 
// 1. put(): O(n) but average case is O(1)
// 2. get(): O(1) but average case is O(1)
// 3. remove(): O(1)  but average case is O(1)
// Space Complexity : O(n) - n is the number of elements present in the hashMap

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashMap {
    vector<vector<pair<int, int>>> hashMap;
    int size;
public:
    MyHashMap() {
        size = 150000;
        hashMap.resize(size);
    }
    
    // if the key is not present put it in the hashMap, if the keys collide then
    // put the key in the list
    void put(int key, int value) {        
        int arr_key = key % size;
        if(this -> get(key) == -1) {
            hashMap[ key % size ].push_back({key, value});
        } else {
            for (int i = 0;i < hashMap[arr_key].size();i ++) {
                if (hashMap[arr_key][i].first == key) {
                    hashMap[arr_key][i].second = value;
                    break;
                }
            }
        }
    }
    
    // find the key using the key as index, if there are multiple entries then use a for loop to search for the key
    int get(int key) {
        int arr_key = key % size;
        int value = -1;
        for (int i = 0;i < hashMap[arr_key].size();i ++) {
            if (hashMap[arr_key][i].first == key) {
                value = hashMap[arr_key][i].second;
                break;
            }
        }

        return value;
    }
    
    // find the key using the key as index and remove it, if there are multiple entries then use a for loop to search for the key
    // and then remove it   
    void remove(int key) {
        int arr_key = key % size;
        for (int i = 0;i < hashMap[arr_key].size();i ++) {
            if (hashMap[arr_key][i].first == key) {
                hashMap[arr_key].erase(hashMap[arr_key].begin() + i);
                break;
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