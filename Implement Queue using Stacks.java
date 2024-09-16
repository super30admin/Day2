/*Time Complexity :O(1)
push() : takes O(1) time
pop() :  amortized O(1) time. In the worst case, pop() would take O(n) time. This is because, if n elements are pushed,
then a pop() would require all the n items to be pushed in the out stack from in stack. Thus the total would be O(2n)(i,e O(n)
for push, O(2n) for first pop and O(n-1) for other pop's). Thus, on average, O(2n/2n) will be O(1). Thus amortized.
peek() : amortized O(1) time.
empty() : O(1).
Space Complexity : Overall is O(n).
push(): O(n) as stack is used to store.
pop() : O(1)
peek() : O(1)
empty() : O(1)
 */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> in_stack;
    Stack<Integer> out_stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        in_stack = new Stack<>();
        out_stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in_stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        /*if(out_stack.isEmpty()){
            while(!in_stack.isEmpty()){
                out_stack.push(in_stack.pop());
            }
        }*/
        return out_stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(out_stack.isEmpty()){
            while(!in_stack.isEmpty()){
                out_stack.push(in_stack.pop());
            }
        }
        return out_stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in_stack.isEmpty() && out_stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */