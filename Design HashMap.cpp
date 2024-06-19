// Approach: used the same approach which was taught by sir while solving hash set ques. double hashing. but rather than using bool 2d array, i used int arr to store the value along with the key instead of just true/false, like in hash set.
// Time complexity: O(1)
// Space complexity: O(n)

class MyHashMap {
vector<vector<int>> storage;
int buckets, bucketItems;
int hash1(int key) {
    return key % buckets;
}
int hash2(int key) {
    return key / bucketItems;
}
public:
    MyHashMap() {
        buckets = 1000, bucketItems = 1000;
        storage.resize(buckets);
    }
    
    void put(int key, int value) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket].empty()) {
            storage[bucket].resize(bucketItems, -1);
        }
        storage[bucket][bucketItem] = value;
    }
    
    int get(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket].empty()) {
            return -1;
        }
        return storage[bucket][bucketItem];
    }
    
    void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket].empty()) {
            return;
        }
        storage[bucket][bucketItem] = -1;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */