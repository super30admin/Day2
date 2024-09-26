#include <stdio.h>
#include <vector>
#include "stack"

using namespace std;

class MyHashMap {
public:
    vector<vector<int>> storage;
    int buckets;
    int bucketItems;
    MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        storage.resize(buckets);
    }
    int getBucket(int key){
        return key%1000;
    }
    int getBucketItems(int key){
        return key/1000;
    }
    void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucket(key);
        if(storage[bucket].empty()){
            storage[bucket] = vector<int> (1000,-1);
        }
        storage[bucket][bucketItem] = value;
    }

    int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucket(key);
        if(storage[bucket].empty() || storage[bucket][bucketItem] == -1){
            return -1;
        }
        return storage[bucket][bucketItem];
    }

    void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucket(key);
        if(storage[bucket].empty() || storage[bucket][bucketItem] == -1){
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