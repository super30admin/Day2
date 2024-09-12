// Time Complexity : Push: O(1), Pop: O(N), Peek: O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> output = new Stack<Integer>();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if(output.empty()){
            while(!input.empty()){
                output.push(input.pop());
            }
            return output.peek();
        }
        else{
            return output.peek();
        }
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}