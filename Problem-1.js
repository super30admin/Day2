

var MyQueue = function() {
    this.s1= [];
    this.s2 = []
};
// Time: O(1)
MyQueue.prototype.push = function(x) {
    this.s1.push(x)
};
// Time: O(N)
MyQueue.prototype.pop = function() {
     if(this.s2.length === 0) {
        while(this.s1.length > 0) 
            this.s2.push(this.s1.pop())
    }
    return this.s2.pop();
};

// Time: O(1)
MyQueue.prototype.peek = function() {
    if(this.s2.length == 0) return this.s1[0];
    return this.s2[this.s2.length-1];
};

// Time: O(1)
MyQueue.prototype.empty = function() {
    return this.s2.length == 0 && this.s1.length == 0
};

