/*
Time complexity - Avg.-> O(1), worst case O(N)
Space complexity - O(N)
*/

class MyHashSet {
    vector<list<int>> m_set;
    int m_factor = 2203;
    
    int hash(int key){
        return key % m_factor;
    }
    
    list<int>::iterator search(int key){
        int idx = hash(key);
        return find(m_set[idx].begin(), m_set[idx].end(), key);
    }
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        m_set.resize(m_factor);
    }
    
    void add(int key) {
        int idx = hash(key);
        if (!contains(key)) m_set[idx].push_back(key);
    }
    
    void remove(int key) {
        int idx = hash(key);
        auto it = search(key);
        if (it != m_set[idx].end()) m_set[idx].erase(it);
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int idx = hash(key);
        return search(key) != m_set[idx].end();
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
