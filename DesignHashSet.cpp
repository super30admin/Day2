// Time Complexity :
                    //remove O(1)
                    //insert O(1)
                    //contains O(1)
                    
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
public:
    /** Initialize your data structure here. */
    //this is the limit of the hashset or in other words size of the array
    int arr[1000001];
    MyHashSet() {
       //initialized the array to -1
        memset(arr,-1,sizeof(arr));
    }
    
    void add(int key) {
        //store the key at the position of the key
        arr[key]=key;
    }
    
    void remove(int key) {
        //set the key value to -1
        arr[key]=-1;
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        //if the value of the key is -1 then return false as there is no value and if the array contains any other value then return true
        return arr[key]==-1?false:true;
    }
};
