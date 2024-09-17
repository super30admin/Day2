//Runtime : O(1)
//Space Complexity: O(n)
#include <vector>
using namespace std;
class MyHashSet {
private:
    int bucket(int key, int buckets){
        return key % buckets;
    }
    int bucketItem(int key, int bucketItems){
        return key/bucketItems;
    }
public:
    /** Initialize your data structure here. */
    int buckets=1001;
    int bucketItems=1000;
    vector<vector<bool>>container;
    MyHashSet() {
       for(int i=0; i<buckets; i++){
           vector<bool> c1;
           container.push_back(c1);
       }
    }
    
    
    
    void add(int key) {
        int b = bucket(key,buckets);
        int bi = bucketItem(key,bucketItems);
        if(container.at(b).empty()){
            for(int i=0; i<=bucketItems; i++){
                container.at(b).push_back(false);
            }
        }
        container.at(b).at(bi) = true;
    }

    
    void remove(int key) {
        int b = bucket(key,buckets);
        int bi = bucketItem(key,bucketItems);
        if(!container.at(b).empty()){
            container.at(b).at(bi) = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int b = bucket(key,buckets);
        int bi = bucketItem(key,bucketItems);
        if(!container.at(b).empty()){
            return container.at(b).at(bi);
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
