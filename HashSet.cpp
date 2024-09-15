#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had issue using boolean 2d array

class MyHashSet {
private:
        int primarySize = 1000;
        int secondarySize = 1000;
        vector<vector<bool>> HashSetStorage;
        
        int getPrimaryIndex(int currValue)
        {
            return currValue % primarySize;
        }

        int getSecondaryIndex(int currValue)
        {
            return currValue / secondarySize;
        }
public:
    MyHashSet() {
        HashSetStorage.resize(primarySize);
    }

    // Time Complexity : O(1) Constant Time
    // Space Complexity : O(1) Constant Time
    void add(int key) {
        int primIndex = getPrimaryIndex(key);
        int secondaryIndex = getSecondaryIndex(key);
        if(HashSetStorage[primIndex].empty())
        {
            if(primIndex == 0)
            {
                HashSetStorage[primIndex] = vector<bool>(secondarySize + 1);
            }
            else
            {
                HashSetStorage[primIndex] = vector<bool>(secondarySize);
            }
        }

        HashSetStorage[primIndex][secondaryIndex] = true;
    }
    
    // Time Complexity : O(1) Constant Time
    // Space Complexity : O(1) Constant Time
    void remove(int key) {
        int primIndex = getPrimaryIndex(key);
        int secondaryIndex = getSecondaryIndex(key);

        if(HashSetStorage[primIndex].empty())
        {
            return;
        }   
        HashSetStorage[primIndex][secondaryIndex] = false;
    }
    
    // Time Complexity : O(1) Constant Time
    // Space Complexity : O(1) Constant Time
    bool contains(int key) {
        int primIndex = getPrimaryIndex(key);
        int secondaryIndex = getSecondaryIndex(key);

        if(HashSetStorage[primIndex].empty())
        {
            return false;
        }   
        return HashSetStorage[primIndex][secondaryIndex];
    }
};

int main()
{
    MyHashSet hs;
}