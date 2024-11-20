import java.util.Stack;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    public MyQueue() {

    }

    public void push(int x) {
        if(!stack1.isEmpty()){
            stack1.push(x);
        }else{
            while(!stack2.isEmpty()){
                int popped2 = stack2.pop();
                stack1.push(popped2);
            }
            stack1.push(x);
        }
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                int popped1 = stack1.pop();
                stack2.push(popped1);
            }
        }
        return  stack2.pop();
    }

    public int peek() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        else{
        }
        return stack1.get(0);
    }

    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty())
            return true;
        return false;
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