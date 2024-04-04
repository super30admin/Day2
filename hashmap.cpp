// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class MyHashMap {
public:
    vector<vector<int>> hash;
    int buckets = 1000;
    int bucketItems = 1001;

    MyHashMap() {
       hash.resize(1000, vector<int>(1000,-1)); 
    }
    
    void put(int key, int value) {
        int hash1 = priHashFunc(key);
        int hash2 = secHashFunc(key);
        hash[hash1][hash2]= value;
    }
    
    int get(int key) {
        int hash1 = priHashFunc(key);
        int hash2 = secHashFunc(key);
        if(hash[hash1][hash2] != -1) {
          return hash[hash1][hash2]; 
        } else {
          return -1;
        }
    }
    
    void remove(int key) {
        int hash1 = priHashFunc(key);
        int hash2 = secHashFunc(key);
        hash[hash1][hash2]=-1;
    }
private:
 int priHashFunc(int key) {
    return key % buckets;
 }    
 int secHashFunc(int key) {
    return key / bucketItems;
 } 
};
    
