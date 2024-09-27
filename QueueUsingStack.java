/**

Problem: Design a queue using a stack
https://leetcode.com/problems/implement-queue-using-stacks/

Solution: Maintain two stacks - in and out. During a push operation, we simply put the element into the in stack. In the case of pop / peek, we can pop / peek from the out stack if the out stack isn't empty.
if the out stack is empty, we would transfer all the elements from the in stack to the out stack and then pop or peek from the out stack. 

- Time Complexity : Time complexity for push is always O(1). The amortized time complexity for pop() or peek() is O(1).
- Space Complexity : Space complexity is O(n) since we're storing every element only once either in the in stack or in the out stack.
- Did this code successfully run on Leetcode : Yes
- Any problem you faced while coding this : No
*/

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if (out.isEmpty()) {
            transferElementsToOutStack();
        }
        return out.pop();
    }
    
    public int peek() {
        if (out.isEmpty()) {
            transferElementsToOutStack();
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
    
    private void transferElementsToOutStack() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }
}