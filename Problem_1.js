// Time Complexity : All methods have O(1)
// Space Complexity : O(n) space in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Reused the hash set technique from Design-1 class to design the following hash map. Instead of storing boolean val, store the actual value provided by user. 

var MyHashMap = function() {
    this.storage = new Array(1000).fill(null);
    this.slots = 1000;
    this.slotItem = 1000;
};

MyHashMap.prototype.slotIdx = function(key) {
    return key%this.slots;
};

MyHashMap.prototype.slotItemIdx = function(key) {
    return parseInt(key/this.slotItem);
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function(key, value) {
    let slot = this.slotIdx(key);
    let slotItem = this.slotItemIdx(key);
    if(this.storage[slot] == null){
        this.storage[slot] = new Array(this.slotItem).fill(null);
    }
    this.storage[slot][slotItem] = value;
};

/** 
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
    let s = this.slotIdx(key);
    let sI = this.slotItemIdx(key);
    if(this.storage[s] == null || this.storage[s][sI] == null)
        return -1;
    return this.storage[s][sI]; 
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
    let s = this.slotIdx(key);
    let sI = this.slotItemIdx(key);
    if(this.storage[s] == null)
        return;
    this.storage[s][sI] = null; 
};

/** 
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */