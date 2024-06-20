// Time Complexity : All methods have O(1)
// Space Complexity : O(100) space in worst case since n is set for 100. n can be any big value
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Implemented a static array of size 100. Initialized two pointers, head and tail to keep track of the idex of latest pushed element and popped element. 
// This helps with quick retrival of data
var MyQueue = function() {
    this.storage = new Array(100);
    this.head = 0;
    this.tail = 0;
    this.capacity = 100;
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    if (this.head < this.capacity) {
        this.storage[this.tail] = x;
        this.tail++;
    }
    return 'Queue is at maximum capacity, cannot add new element';
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    var val = this.storage[this.head];
    this.storage[this.head] = null;
    if (this.head < this.tail) {
        this.head++;
    }
    return val;
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    return this.storage[this.head];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return (this.head == this.tail)
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */