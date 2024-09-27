// Time Complexity : O(n) for first popping and the remaiming pop will take on average O(1)
// Space Complexity : O(n) Stacks are used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.*;
class started{
static class MyQueue {
    Stack<Integer> S_input = new Stack<>();
    Stack<Integer> S_output = new Stack<>();
    
    public MyQueue() {
        
    }
    
    public void push(int x) {
        S_input.push(x);
    }
    
    public int pop() {
        if(!S_output.isEmpty()) 
        return S_output.pop();
        else {
            while(!S_input.isEmpty()){
                int send = S_input.pop();
                S_output.push(send);
            }
            return S_output.pop();
        }
    }
    
    public int peek() {
        if(!S_output.isEmpty()) 
            return S_output.peek();
        else {
            while(!S_input.isEmpty()){
                S_output.push(S_input.pop());
            }
            return S_output.peek();
        }
    }
    
    public boolean empty() {
        if(S_input.isEmpty() == true && S_output.isEmpty() == true) 
            return true;
        return false;
    }       
}

public static void main(String [] args){
    MyQueue myQueue = new MyQueue();
    myQueue.push(1); // queue is: [1]
    myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    System.out.println(myQueue.peek()); // return 1
    System.out.println("popped element is " + myQueue.pop()); // return 1, queue is [2]
    boolean k = myQueue.empty(); // return false
    System.out.print(k);
}

}