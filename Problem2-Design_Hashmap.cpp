#include <array>
#include <forward_list>

#define STORAGE_SIZE 10000

class MyHashMap {
private:
    struct KeyValuePair {
        int key;
        int value;
    };

    array<forward_list<KeyValuePair>, STORAGE_SIZE> storage;

    int get_storage_hash(int key) {
        return key % STORAGE_SIZE;
    }

public:
    MyHashMap() {
        for (auto& bucket : storage) {
            // Initialize each bucket with an empty forward list
            bucket = forward_list<KeyValuePair>();
        }
    }

    void put(int key, int value) {
        int s_key = get_storage_hash(key);
        auto& bucket = storage[s_key]; 

        // Search for the key in the bucket
        for (auto& pair : bucket) {
            if (pair.key == key) {
                // Key found, update value
                pair.value = value;
                return;
            }
        }

        // Key not found, insert a new key-value pair
        bucket.push_front({key, value});
    }

    int get(int key) {
        int s_key = get_storage_hash(key);
        auto& bucket = storage[s_key]; 

        // Search for the key in the bucket
        for (const auto& pair : bucket) {
            if (pair.key == key) {
                // Key found, return value
                return pair.value;
            }
        }

        // Key not found
        return -1;
    }

    void remove(int key) {
        int s_key = get_storage_hash(key);
        auto& bucket = storage[s_key]; // Get reference to the bucket

        auto prev_it = bucket.before_begin();
        for (auto it = bucket.begin(); it != bucket.end(); ++it) {
            if ((*it).key == key) {
                // Key found, remove the element
                bucket.erase_after(prev_it);
                return;
            }
            prev_it = it;
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