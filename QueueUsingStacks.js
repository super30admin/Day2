// Time Complexity : O(log N)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class MyQueue {
  constructor() {
    this.inStack = [];
    this.outStack = [];
  }

  /**
   * @param {number} x
   * @return {void}
   */
  push = (x) => {
    this.inStack.push(x);
  };

  /**
   * @return {number}
   */
  peek = () => {
    if (!this.outStack.length) {
      while (this.inStack.length > 0) {
        this.outStack.push(this.inStack.pop());
      }
    }
    return this.outStack[this.outStack.length - 1];
  };

  /**
   * @return {number}
   */
  pop = () => {
    this.peek();
    return this.outStack.pop();
  };

  /**
   * @return {boolean}
   */
  empty = () => {
    return !this.inStack.length && !this.outStack.length;
  };
}

var obj = new MyQueue();
obj.push(1);
obj.push(2);
obj.push(3);
console.log(obj.peek());
console.log(obj.pop());
console.log(obj.peek());
console.log("isempty", obj.empty());
/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
