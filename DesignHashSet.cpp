// Time Complexity -- add(key), remove(key) and contains(key) is O(1) since we are directly accessing the vectors using the indices.
// Space Complexity -- It is O(1) since the space used is directly proportional to the number of elements added.

// Problems faced - 1. I faced difficulty in initializing the vector but the hint provided in the cohort slack channel to use resize() function saved the day.
//                  2. I was directly comparing the vector[index] to NULL which threw errors. Using vector[index].empty() resolved it. Hint was provided on the slack channel.

// It runs on leetcode.

class MyHashSet {
private: 
    vector<vector<bool>> hSet;
    int buckets;
    int bucketItems;
public:
    MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        hSet.resize(buckets);
    }

    int bucketIndex(int key){
        return key%buckets;
    }
    
    int bucketItemIndex(int key){
        return key/bucketItems;
    }
    
    void add(int key) {
        int bIndex = bucketIndex(key);
        int bItemIndex = bucketItemIndex(key);
        
        if(hSet[bIndex].empty()){
            if(bIndex == 0)
                hSet[bIndex] = vector<bool>(bucketItems+1);
            else
                hSet[bIndex] = vector<bool>(bucketItems);
        }
        hSet[bIndex][bItemIndex] = true;
    }
    
    void remove(int key) {
        int bIndex = bucketIndex(key);
        int bItemIndex = bucketItemIndex(key);
        
        if(hSet[bIndex].empty())
            return;
        hSet[bIndex][bItemIndex] = false;
    }
    
    bool contains(int key) {
        int bIndex = bucketIndex(key);
        int bItemIndex = bucketItemIndex(key);
        
        if(hSet[bIndex].empty())
            return false;
        else
            return hSet[bIndex][bItemIndex];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
