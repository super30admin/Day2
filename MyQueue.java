import java.util.Stack;

// Time Complexity : Amortised O(1) : on an average not every time we're performing move operation.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : To find the space complexity, still confused if its right one.(PLEASE CHECK S.C)



//logic here for pop is we're gonna move the value from 1st stack to 2nd as it'll reverse them in order which is queue scenario
//and then pop /peek the values from 2nd stack
class MyQueue {
    //1st stack to push the value.
    Stack<Integer> inStack;
    //2nd stack to pop or peek the value
    Stack<Integer> outStack;
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    private void move(){
        //If 2nd stack is empty move all the values from 1 -> 2 stack.
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }

    public int pop() {
        this.move();
        return outStack.pop();
    }

    public int peek() {
        this.move();
        return outStack.peek();
    }

    public boolean empty() {
        return (inStack.isEmpty() && outStack.isEmpty());
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
