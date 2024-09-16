// Time Complexity : O(1)
// Space Complexity : O(N) creating new stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



import java.util.Stack;

public class MyQueue {

    //creating two stacks
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue(){

        this.in = new Stack<>();
        this.out = new Stack<>();


    }

    //pushing value to in stack
    //Time Complexity: O(1)
    public void push(int x){
        in.push(x);
    }

    //returns the top value from stack out
    //out contains the popped value from in
    //Time Complexity: O(1)
    public int peek(){
        if(out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
            return out.peek();
    }

    //calls the peek function to the first added value
    // Time Complexity: O(1)
    public int pop(){
        peek();
        return out.pop();
    }

    //returns true if both the stacks are empty
    //Time ComplexIty: O(1)
    public boolean empty(){
        if(in.isEmpty() && out.isEmpty()) {
            return true;
        }
        return false;

    }

}
