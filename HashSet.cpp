/*
 Time Complexity: O(1), as I am using Bitset for the implementation

 Space Complexity: O(n) but still it's less then normal array or vector since bitste uses only 1bit to represent boolen value

Did this code successfully run on Leetcode : Yes, results on Leetcode, Runtime: 87 ms, faster than 80.14% of C++ online submissions for Design HashSet.
Memory Usage: 43.5 MB, less than 40.13% of C++ online submissions for Design HashSet..

 Your code here along with comments explaining your approach,
 1. I am using bitset to store the keys
 2. As we know HashSet allows only unique entries, so I have initialized enough big bitset that it can conatin all the unique keys in given range on github.
 3. To add any key I am setting that bit.
 3. To remove an element, I am making that bit as 0.
 4. hashSet Contains method checks whether the bit for the given key is set or not and return the value accoring to it.
  */



class MyHashSet {
public:
    bitset<1000001> b;
    
    MyHashSet() {
        
    }
    
    void add(int key) {
        b.set(key);
    }
    
    void remove(int key) {
        b[key]=0;
    }
    
    bool contains(int key) {
        return b[key]==1;;
    }
};