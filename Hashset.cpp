// Time Complexity : O(1) for all functions
// Space Complexity : O(n)

class MyHashSet {
public:
    /** Initialize your data structure here. */
    int arr[1000001];
    MyHashSet() {
        memset(arr,-1,sizeof(arr));
    }
    
    void add(int key) {
        arr[key]=1;
    }
    
    void remove(int key) {
        arr[key]=-1;
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        if(arr[key]==-1){
            return false;
        }
        return true;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */