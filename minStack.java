// Time Complexity : Pop - O(1), Peek - O(1), Top - O(1), getMin - O(1)
// Space Complexity : Two stacks - O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Edge case for adding '<=' on line 19


// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> stack, minStack;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }

    public void pop() {
        if(!stack.isEmpty()){
            int topElement = stack.pop();
            if(minStack.peek() == topElement) minStack.pop();
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}