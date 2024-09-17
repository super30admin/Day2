//time complexity: O(1)
//space complexity:O(n)
//approach: using 1 array
//solved on leetcode? yes
//problem faced? yes, I could only solve it with this approach.
class MyHashSet {
public:
    /** Initialize your data structure here. */
    int a[1000001];
    MyHashSet() {
        memset(a,-1,1000001);
    }
    
    void add(int key) {
        a[key]=key;
    }
    
    void remove(int key) {
        a[key]=-1;
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        if(a[key]!=key)
            return false;
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