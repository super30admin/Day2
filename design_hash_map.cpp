// Time Complexity : O(1)
// Space Complexity : O(1) constant space for 10^6 elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A

class MyHashMap {
public:
    MyHashMap() {
        size_of_vectors = 1001;
        map.resize(size_of_vectors);
    }
    
    int hash1(int key)
    {
        return key % size_of_vectors;
    }

    int hash2(int key)
    {
        return key / size_of_vectors;
    }

    void put(int key, int value) {
        int h1 = hash1(key);

        if(map[h1].empty() == true)
        {   
            map[h1].resize(size_of_vectors);
            std::fill(map[h1].begin(), map[h1].end(),-1);
        }

        int h2 = hash2(key);

        map[h1][h2] = value;
    }
    
    int get(int key) {

        int h1 = hash1(key);

        if(map[h1].empty() == true)
        {
            return -1;
        }

        int h2 = hash2(key);

        return map[h1][h2];
        
    }
    
    void remove(int key) {
        int h1 = hash1(key);

        if(map[h1].empty() == true)
        {
            return;
        }

        int h2 = hash2(key);

        map[h1][h2] = -1;
    }

private: 
    std::vector<std::vector<int>> map;
    int size_of_vectors;
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */