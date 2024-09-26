// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Approach: We will use two stacks: first one will store all the data we intend to push to the queue
//The second stack will contain the reveresed ordered values of the previous stack obtained from popping values from firstStack
import java.util.Stack;

public class MyQueue {
    
    private Stack<Integer> firstStack = new Stack<>();
    private Stack<Integer> secondStack = new Stack<>();

    public MyQueue() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }
    
    public void push(int x) {
        firstStack.push(x);
    }
    
    public int pop() {
        if(secondStack.isEmpty())
        {
            switchStacks();
        }
        return secondStack.pop();
    }
    
    public int peek() {
        if(secondStack.isEmpty())
        {
            switchStacks();
        }
        return secondStack.peek();
    }
    
    public boolean empty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }
    
    public void switchStacks() {
        while (!firstStack.isEmpty()) {
            int temp = firstStack.pop();
            secondStack.push(temp);
        }
    }

    public static void main(String args[]) 
    { 
        MyQueue obj = new MyQueue();
        obj.push(3);
        obj.push(4);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
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