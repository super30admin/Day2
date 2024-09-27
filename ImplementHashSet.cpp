// Space Complexity - In worst case O(range of values of Keys)

// Time Complexity - O(1)

// Successfully ran on Leetcode

// Problems Faced - Was not able to initialize 2d array in c++ without giving dimensions for the secondary array.
// I tried using primary array having pointers to the secondary array. But it asked me to initialize size for the secondary array at first which defeted the purpose.
// Therefore, I had to use vector instead. 


#include <iostream>
#include <vector>

using namespace std;

class MyHashSet {
public:
    vector< vector<bool> > vec;
    MyHashSet(){
        for(int i=0;i<1000;i++)
        {
            vector<bool> vec3;

            vec.push_back(vec3);
        }
    }
    int  ReturnPrimaryArrayIndex(int key)
    {
        return key%1000;
    }
    
    int ReturnSecondaryArrayIndex(int key)
    {
        return key/1000;
    }
    
    void add(int key) {
        int primaryArrayIndex=ReturnPrimaryArrayIndex(key);
        int secondaryArrayIndex=ReturnSecondaryArrayIndex(key);
        if(vec[primaryArrayIndex].empty())
        {     
            for(int i=0;i<1000;i++)
            {
                vec[primaryArrayIndex].push_back(false);
            }
            if(primaryArrayIndex==0)
            {
                vec[primaryArrayIndex].push_back(false);
            }
        }
        vec[primaryArrayIndex][secondaryArrayIndex]=true;
    }
    
    void remove(int key) {
        int primaryArrayIndex=ReturnPrimaryArrayIndex(key);
        int secondaryArrayIndex=ReturnSecondaryArrayIndex(key);
        if(vec[primaryArrayIndex].empty())
        {
            return;
        }
        vec[primaryArrayIndex][secondaryArrayIndex]=false;
    }
    
    bool contains(int key) {
        int primaryArrayIndex=ReturnPrimaryArrayIndex(key);
        int secondaryArrayIndex=ReturnSecondaryArrayIndex(key);
        if(vec[primaryArrayIndex].empty())
        {
            return false;
        }
        return vec[primaryArrayIndex][secondaryArrayIndex];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */