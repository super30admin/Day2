// Time Complexity : O(2n)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.io.*; 
import java.util.*; 

class MyQueue { 
    Stack<Integer> stackTemp;
     Stack<Integer> stackQueue;  
    public MyQueue() {
        stackTemp = new Stack<>();
        stackQueue = new Stack<>();  
    }
    
    public void push(int x) {
        stackTemp.push(x);
    }
    
    public int pop() {
        if(stackTemp.isEmpty() && stackQueue.isEmpty())return -1;
        if(stackQueue.isEmpty()){
            while(!stackTemp.isEmpty()){
                stackQueue.push(stackTemp.pop());
            }
        }
        return stackQueue.pop();
    }
    
    public int peek() {
        if(stackTemp.isEmpty() && stackQueue.isEmpty())return -1;
        if(stackQueue.isEmpty()){
            while(!stackTemp.isEmpty()){
                stackQueue.push(stackTemp.pop());
            }
        }
        
        return stackQueue.peek();      
    }
    
    public boolean empty() {
        return stackQueue.isEmpty() && stackTemp.isEmpty();
    }

    public static void main(String args[]) 
    { 
        MyQueue queue = new MyQueue();





        queue.push(1);



        queue.push(2);  



        queue.peek();  // returns 1



        queue.pop();   // returns 1



        queue.empty(); // returns false
    }
}