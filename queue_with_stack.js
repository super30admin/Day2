// Time Complexity : Push, Pop, Peek O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

var MyQueue = function () {
  this.in_stack = [];
  this.out_stack = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function (x) {
  this.in_stack.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function () {
  if (this.out_stack.length == 0) {
    this.transfer();
  }
  return this.out_stack.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function () {
  if (this.out_stack.length == 0) {
    this.transfer();
  }
  return this.out_stack[this.out_stack.length - 1];
};

MyQueue.prototype.transfer = function () {
  while (this.in_stack.length != 0) {
    this.out_stack.push(this.in_stack.pop());
  }
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function () {
  return this.in_stack.length == 0 && this.out_stack.length == 0;
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */

test("Scenario #1:", () => {
  var obj = new MyQueue();
  obj.push(1);
  obj.push(2);
  obj.push(3);
  obj.push(4);

  expect(obj.pop()).toStrictEqual(1);
  expect(obj.peek()).toStrictEqual(2);
  expect(obj.empty()).toStrictEqual(false);
});
