// Time Complexity : O(1)

// Did this code successfully run on Leetcode : Yes code ran successfully on Leetcode

// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach

// MyHashSet is a wrapper around JS object to allow HashSet Operations
var MyHashSet = function() {
    this.set = {}
};

/** 
 * Adds the key to the HashSet
 * @param {number} key
 * @return {void}
 */

MyHashSet.prototype.add = function(key) {
        this.set[key] = key
};

/** 
 * Removes the key from the HashSet
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function(key) {
    delete this.set[key]
};

/** 
 * Checks if the key exists in HashSet
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function(key) {
    return this.set[key] ? true : false
};

/** 
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */