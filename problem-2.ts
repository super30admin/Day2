// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyQueue {
    // define 2 stacks 
    pushStack = [];
    popStack = [];

    push(element: number): void {
        // push to stack
        this.pushStack.push(element);
    }

    pop(): number {
        // check popStack length to verify it's empty
        if(!this.popStack.length){
            // move all elements to pop stack to extract the first element
            while(this.pushStack.length){
                this.popStack.push(this.pushStack.pop());
            }
        }
        // extract the first element
        return this.popStack.pop();
    }

    peek(): number {
        if(!this.popStack.length){
            while(this.pushStack.length){
                this.popStack.push(this.pushStack.pop());
            }
        }
        // peek first element
        return this.popStack[this.popStack.length - 1];
    }

    empty(): boolean {
        return !this.pushStack.length && !this.popStack.length;
    }
}

// Example
 const obj = new MyQueue()
 obj.push(1);
 obj.push(2);
 obj.push(3);
 obj.push(4);
 const param_2 = obj.pop();
 const param_3 = obj.peek();
 const param_4 = obj.empty();


/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */