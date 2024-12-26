// Time Complexity : O(1) for push,pop,peek,empty().
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

Used two stack approach one to just insert value from front to last(firststack) and other(secondstack) to get popped out value from first stack(firststack)
var MyQueue = function() {
    this.firststack=[];
    this.secondstack=[];
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    
    this.firststack.push(x);
    
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function() {
   this.prepare();
    return this.secondstack.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function() {
  this.prepare();
  return this.secondstack[this.secondstack.length-1];
};
/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return this.firststack.length===0 && this.secondstack.length===0;
};

MyQueue.prototype.prepare = function(){
    if(this.secondstack.length===0)
    while(this.firststack.length>0)
        this.secondstack.push(this.firststack.pop());
}

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
