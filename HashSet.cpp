// Time Complexity O(N/K)  - K being capacity or defined size of array 
// Space Complexity O(M+K) - M being unique elements inserted and K being capacity or defined size of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
#include <iostream>
#include <vector>

using namespace std;

class MyHashSet {
private:
    vector<vector<int>> HashSet;
    int capacity;
    /** Initialize your data structure here. */
public:
    MyHashSet() {
        capacity = 2069; //array size
        for (int i = 0;i < capacity;i++) {
            vector<int> temp;
            HashSet.push_back(temp);
        }
    }
    //Hash function to generate hash code for each key
    int generateHashCode(int key) {
        return key % capacity;
    }
    
    /*Get the hashcode for given key and use it as index to find 
      the appropriate bucket to insert given key. if key is already present,
      do nothing else insert it into respective bucket.

    */
    void add(int key) {
        bool found = false;
        int index = generateHashCode(key);
      //  vector<int> temp = HashSet[index];
        for (auto i : HashSet[index]) {
            if (i == key) {
                found = true;
                break;
            }
        }
        if (!found) {
            HashSet[index].push_back(key);
        }
    }
    /*Get the hashcode for given key and use it as index to access 
      the bucket where key might be present. If key is found remove it.
    */
    void remove(int key) {
        int index = generateHashCode(key);
        for (int i = 0;i < HashSet[index].size();i++) {
            if (HashSet[index][i]== key) {
                HashSet[index].erase(HashSet[index].begin() + i);
                break;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int index = generateHashCode(key);
        for (auto i : HashSet[index]) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }
};

int main() {
    MyHashSet* hashSet = new MyHashSet();
    hashSet->add(1);
    hashSet->add(2);
    cout << hashSet->contains(1) << endl;    // returns true
    cout << hashSet->contains(3) << endl;    // returns false (not found)
    hashSet->add(2);
    cout << hashSet->contains(2) << endl;
    hashSet->remove(2);
    cout << hashSet->contains(2) << endl;     // returns false (already removed)
    return 0;
}   