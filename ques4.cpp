Time Complexity-O(1)
Space Complexity-O(n)
Did the code run on Leetcode? Yes

#include <bits/stdc++.h>
#include <iostream>
using namespace std;

class MyHashSet {
public:
    bool m[1001][1000];
    /** Initialize your data structure here. */
    MyHashSet() {
        memset(m, 0, sizeof(bool)*1001*1000);
    }
    
    void add(int key) {
        m[key%1000][key/1001]=true;
    }
    
    void remove(int key) {
        if(m[key%1000][key/1001]==true)
         {
            m[key%1000][key/1001]=false;              
         }
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        if(m[key%1000][key/1001]==true)
                       cout<<true;
        else
                       cout<<false;
        cout<<"\n";
    }
};

int main() {
	MyHashSet hash;
	hash.add(1);         
    hash.add(2);         
    hash.contains(1);    // returns true
    hash.contains(3);    // returns false (not found)
    hash.add(2);          
    hash.contains(2);    // returns true
    hash.remove(2);          
    hash.contains(2); // returns false (already removed)
	return 0;
}