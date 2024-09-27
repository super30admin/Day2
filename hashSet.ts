// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : 27 / 28 test cases passed.
// Any problem you faced while coding this : I couldn't pass the last test case at leetcode


class MyHashSet {
    data = [];
    memory = 100;
    hash(key) {
        return key / this.memory;
    }
    /** 
     * @param {number} key
     * @return {void}
     */

    //only add key if the set doesn't have the key because a set has unique values
    add(key) {
        let index = this.hash(key);
        if(!this.data[index]) this.data[index] = key;
    };

    /** 
     * @param {number} key
     * @return {void}
     */
    remove(key) {
        let index = this.hash(key);
        this.data[index] = null;
    };

    /**
     * Returns true if this set contains the specified element 
     * @param {number} key
     * @return {boolean}
     */
    contains(key) {
        let index = this.hash(key);
        if(this.data[index]) return true;
        else return false;
    };
}