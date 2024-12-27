import java.util.Stack;

// Time Complexity : Time complexity is O(1) in push , empty, pop and peek is amortized O(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue(){

    }

    //If there is push. It need to be pushed in stack1
    public void push(int x){
        stack1.push(x);
    }

    //If stack 2 is empty then push element from stack1 and then pop. Otherwise directly pop from stack2
    public int pop(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }
    }

    //If stack 2 is empty then push element from stack1 and then return stack2 peek. Otherwise directly return stack2 peek
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    //If both stacks are empty then return true
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
