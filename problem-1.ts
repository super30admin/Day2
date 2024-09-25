// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyHashSet {
    // initialize data structure
    obj = {};

    add(key: number) {
        // insert a element into hashset
        this.obj[key] = true;
    }

    remove(key: number) {
        // remove element from hashset
        this.obj[key] = false;
    }

    contains(key: number) {
        // verify if element exists in hashset
        return this.obj[key] ? true : false;
    }
};

//Example:
const hashSet = new MyHashSet();
hashSet.add(5);
hashSet.add(10);
hashSet.remove(5);
hashSet.contains(5); // returns false
const isExists = hashSet.contains(10);
console.log(isExists);
    

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */