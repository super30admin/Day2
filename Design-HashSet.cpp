// Time Complexity : O(N) for all operations in worst case. 
// Can be improved using Balanced BST instead of linkedlist for chaining.
// Space Complexity : O(N) for storing data
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet 
{
    vector < list<int> > hashdata;
    int hashkey = 10007;
        
public:
    
    MyHashSet() 
    {
        hashdata.resize(hashkey);
    }
    
    void add(int key) 
    {
        int hash = key%hashkey;
        
        auto &list=hashdata[hash];
        
        for(auto node : list)
        {
            if(node==key)
                return;
        }
        list.push_back(key);
    }
    
    void remove(int key) 
    {
        int hash = key%hashkey;
        
        auto &list=hashdata[hash];
        
        for(auto node : list)
        {
            if(node==key)
            {
               list.remove(key); 
                return;
            }     
        }
    }
    
    bool contains(int key) 
    {
        int hash = key%hashkey;
        
        auto &list=hashdata[hash];
        
        for(auto node :list)
        {
            if(node==key)
                return true;    
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