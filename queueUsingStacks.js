// Time Complexity : Average case O(1), worst case O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class MyQueue {
    in = [];
    out = [];
    push(num) {
        this.in.push(num);
    }
    pop() {
        if(this.out.length === 0) {
            let len = this.in.length;
            for(let i = 0; i < len; i++) {
                this.out.push(this.in.pop());
            }
        }        
        return this.out.pop();
    }
    peek() {
        if(this.out.length === 0) return this.in[0];
        else return this.out[this.out.length - 1];
    }
    empty() {
        if(this.in.length + this.out.length === 0) return true;
        else return false;
    }
};

/////////////////////////////
// OLD SOLUTION

class MyQueue {
    /**
 * Push element x to the back of queue. 
 * @param {number} x
 * @return {void}
 */
    data = [];
    push(num) {
        this.data.push(num);
    }
    /**
 * Removes the element from in front of queue and returns that element.
 * @return {number}
 */
    pop() {
        return this.data.shift();
    }
    /**
 * Get the front element.
 * @return {number}
 */
    peek() {
        return this.data[0];
    }
    /**
 * Returns whether the queue is empty.
 * @return {boolean}
 */
    empty() {
        if(this.data.length === 0) return true;
        else return false;
    }
}

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */