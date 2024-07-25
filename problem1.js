// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach
// Time Complexity : O(1)
// Space Complexity : O(1)
var MyQueue = function() {
    this.s1 = [];
    this.s2 = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
// Time Complexity : O(1)
// Space Complexity : O(1)
MyQueue.prototype.push = function(x) {
    this.s1.push(x);
};

/**
 * @return {number}
 */
// Time Complexity : O(n)
// Space Complexity : O(1)
MyQueue.prototype.pop = function() {
    if(this.s2.length === 0) {
        while(this.s1.length > 0) {
            this.s2.push(this.s1.pop())
        }
    }
    return this.s2.pop();
};

/**
 * @return {number}
 */
// Time Complexity : O(1)
// Space Complexity : O(1)
MyQueue.prototype.peek = function() {
    if(this.s2.length === 0) {
        while(this.s1.length > 0) {
            this.s2.push(this.s1.pop())
        }
    }
    return this.s2[this.s2.length - 1];
};

/**
 * @return {boolean}
 */
// Time Complexity : O(1)
// Space Complexity : O(1)
MyQueue.prototype.empty = function() {
    return this.s1.length === 0 && this.s2.length === 0 
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */