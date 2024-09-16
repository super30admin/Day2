// Time Complexity : Worst case O(n) for pop, O(1) for rest
// Space Complexity : O(n) for push and O(1) for rest
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Accessing the first element in the stack for popping was a challenge. 


/**
 * Initialize your data structure here.
 */
var MyQueue = function() {
    this.stack1  = [];
    this.stack2 = [];
};

/**
 * Push element x to the back of queue. 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.stack1.push(x);
};

//method to push all the elements in stack 1 to stack 2 in reverse order. So this makes it easy to pop and peek. 
MyQueue.prototype._pushBack = function() {
    while(this.stack1.length > 0) {
        this.stack2.push(this.stack1.pop());
    }
}

/**
 * Removes the element from in front of queue and returns that element.
 * @return {number}
 */

MyQueue.prototype.pop = function() {
    if(this.empty()) return null

    if(this.stack2.length === 0){
        this._pushBack()
    }
    return this.stack2.pop()
};

/**
 * Get the front element.
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    if(this.stack1.length > 0){
        return this.stack1[0]
    }
    return this.stack2[this.stack2.length -1];
    
};

/**
 * Returns whether the queue is empty.
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return this.stack1.length === 0 && this.stack2.length === 0
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */