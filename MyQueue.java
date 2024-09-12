// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();


    }

    public void push(int x) {
        while (!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
        stack1.push(x);

        while (!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();


    }

    public int peek() {
        int x = stack1.peek();
        return x;
    }

    public boolean empty() {
        if (stack1.isEmpty()){
            return true;
        }
        else
        {
            return false;
        }

    }
}