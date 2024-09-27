// Time Complexity :
// push: O(1)
// pop: Avg - O(1); Worst case - O(N), where N is the number of elements in the 'in' stack
// peek: Avg - O(1); Worst case - O(N), where N is the number of elements in the 'in' stack
// Empty: O(1)

// Space Complexity : 
// O(N): N is the elements pushed into the stacks

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// 232. Implement Queue using Stacks

var MyQueue = function () {
    // We will maintain 2 stacks to mimic queue behavior
    this.in = [];
    this.out = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function (x) {
    // Push elements in 'in' stack
    this.in.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function () {
    // On pop, if out stack has elements, pop the top 
    // else push elements from 'out' stack in the 'in' stack
    // then pop the top element
    this.peek();
    return this.out.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function () {
    // If 'out' stacks length is 0, then push elements from 'out' stack in the 'in' stack
    if (this.out.length === 0) {
        while (this.in.length !== 0) {
            this.out.push(this.in.pop());
        }
    }
    // Return value of top element
    return this.out.at(-1);
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function () {
    // Return true if both the 'out' and 'in' stacks are empty
    return this.in.length === 0 && this.out.length === 0;
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */