// Time Complexity : Add, Remove, Contains - O(1)
// Space Complexity : O(n) - Since Space being allocated as elements are added
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : -

class MyHashSet {
private:
    //Array of 1000 bool pointers
    bool *arr[1000] = {0}; //All false by default

    //Variable to hold value of element 1000000
    bool lastElem;
    //Creating a 1001 array might have been a waste of space
    
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        //Last element is not present by default    
        lastElem = false;
        
    }
    
    void add(int key) {

        //Last element condition        
        if(key == 1000000)
        {
            lastElem = true;
            return;
        }
        
        //Primary Index is Index of Array of bool pointers
        int pIdx = key % 1000;

        //Secondary Index is Index of the Array pointed to by the pIdx
        int sIdx = key / 1000;
        
        //Array not allocated condition
        if(arr[pIdx] == NULL)
        {
            bool *newArr = new bool [1000]();
            
            arr[pIdx] = newArr;
            
            *(arr[pIdx] + sIdx) = true;
        }
        //Array already allocated condition
        else
        {
            *(arr[pIdx] + sIdx) = true;
        }
    
    }
    
    void remove(int key) {

        if(key == 1000000)
        {
            lastElem = false;
            return;
        }
        
        int pIdx = key % 1000;
        int sIdx = key / 1000;
        
        //Invalid key condition
        if(arr[pIdx] == NULL)
        {
            return;
        }
        //Set the value as false
        else
        {
            *(arr[pIdx] + sIdx) = false;
        }
        
        return;
        
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        
        if(key == 1000000)
        {
            return lastElem;
        }
        
        int pIdx = key % 1000;
        int sIdx = key / 1000;
        
        //Invalid key condition
        if(arr[pIdx] == NULL)
        {
            return false;
        }
        //Return proper value
        else
        {
            return *(arr[pIdx] + sIdx);
        }        
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */