// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class Sample {
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min){
            minStack.push(min);
            this.min = val;
        }
        minStack.push(val);
    }

    public void pop() {
        int val = minStack.pop();
        if(val == min){
            this.min = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return min;
    }
}
