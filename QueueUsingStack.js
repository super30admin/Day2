//Approach 1
// Time Complexity : push/pop - O(1) peek-O(n) Average O(1)
// Space Complexity : O(n) n is number of entries
// Did this code successfully run on Leetcode : Yes

//Approach 2
// Time Complexity : push - O(n)  pop/peek - O(1)
// Space Complexity : O(n) n is number of entries
// Did this code successfully run on Leetcode : Yes


var MyQueue = function () {
    this.in = [];
    this.out = [];
};


MyQueue.prototype.push = function (x) {
    this.in.push(x);
};


MyQueue.prototype.pop = function () {
    this.peek();
    return this.out.pop();
};


MyQueue.prototype.peek = function () {
    if (this.out.length === 0) {
        while (this.in.length !== 0) {
            this.out.push(this.in.pop())
        }
    }
    return this.out[this.out.length - 1];
};


MyQueue.prototype.empty = function () {
    return (this.in.length === 0 && this.out.length === 0);
};



//Approach 2

var MyQueue = function () {
    this.stack = [];
};


MyQueue.prototype.push = function (x) {
    this.stack.unshift(x);
};


MyQueue.prototype.pop = function () {
    return this.stack.pop();
};


MyQueue.prototype.peek = function () {
    return this.stack[this.stack.length - 1];
};


MyQueue.prototype.empty = function () {
    return this.stack.length === 0;
};


/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */





