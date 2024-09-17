// Time Complexity : O(1) for pop O(n) in worst case
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// Using two stacks to solve this problem
var MyQueue = function () {
  this.stack1 = [];
  this.stack2 = [];
  this.front;
};

//push operation
/**
 * @param {number} x
 * @return {void}
 */
// this function will be pushing the value (x) in stack1, next will be pointing to the very first element.
MyQueue.prototype.push = function (x) {
  if (this.stack1.length === 0) this.front = x;
  this.stack1.push(x);
};

// pop operation
/**
 * @return {number}
 */
// this function will be adding all the values of stack1 to stack2 and will be returning the poped value of the stack2
MyQueue.prototype.pop = function () {
  if (this.stack2.length === 0) {
    while (this.stack1.length !== 0) this.stack2.push(this.stack1.pop());
  }
  return this.stack2.pop();
};

// peek opeartion
/**
 * @return {number}
 */
// this function will return the length - 1 element from stack2 if stack2 is not empty.
// If stack2 is empty, this function will return value of next.
MyQueue.prototype.peek = function () {
  if (this.stack2.length > 0) {
    return this.stack2[this.stack2.length - 1];
  }
  return this.front;
};

//empty operation
/**
 * @return {boolean}
 */
// this function will check the length of both stacks.
MyQueue.prototype.empty = function () {
  return this.stack1.length === 0 && this.stack2.length === 0;
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
