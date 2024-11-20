
//Time COmplexity: O(1)
//Space Complexity: O(1)


import java.util.Stack;

class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    int min = Integer.MAX_VALUE;

    public MinStack() {

        this.mainStack = new Stack();
        this.minStack = new Stack();
        minStack.push(min);

    }

    public void push(int val) {
        mainStack.push(val);
        min=Math.min(min,val);
        minStack.push(min);
    }

    public void pop() {

        mainStack.pop();
        minStack.pop();
        min = minStack.peek();

    }

    public int top() {

        return mainStack.peek();

    }

    public int getMin() {

        return minStack.peek();

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */