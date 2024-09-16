
// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I face difficulties in finding space and time complexity of the solution

var MyStack = function() {
    this.stack = [];
};
MyStack.prototype.push = function(x) {
    this.stack.push(x);
};
MyStack.prototype.pop = function() {
    return this.stack.pop();
};
MyStack.prototype.peek = function() {
    return this.stack[this.stack.length - 1];
};
MyStack.prototype.size = function() {
    return this.stack.length;
};

var MyQueue = function() {
    this.s1 = new MyStack();
    this.s2 = new MyStack();
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    this.s1.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    while (this.s1.peek()) {
        this.s2.push(this.s1.pop())
    }
    let removed = this.s2.pop();
    while (this.s2.peek()) {
        this.s1.push(this.s2.pop())
    }
    return removed;
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    while (this.s1.peek()) {
        this.s2.push(this.s1.pop())
    }
    let latest = this.s2.peek();
    while (this.s2.peek()) {
        this.s1.push(this.s2.pop())
    }
    return latest;
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return this.s1.size() === 0
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */