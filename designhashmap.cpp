// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no
class MyHashMap {
public:
    //using vector same logic as previous pull req
    //bruteforce
    vector<int>nums;
    int n;
    MyHashMap() {
        //as described in the que 0 <= key, value <= 10^6
       n = 10e6+1;
       nums.resize(n-1);
       fill(nums.begin(),nums.end(),-1);
    }
    
    void put(int key, int value) {
        nums[key] = value;
    }
    
    int get(int key) {
        return nums[key];
    }
    
    void remove(int key) {
        nums[key]=-1;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */