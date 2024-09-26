import java.util.Stack;

// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : took a couple tries, but used debugger to fix all issues


// Your code here along with comments explaining your approach
class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front; // element at front of queue
    
    public MyQueue() { // Constructor
        s1 = new Stack<Integer>(); 
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (s1.empty()){
            front = x;
        }
        s1.push(x); // note for self: push here is push method for stack, not same as push method in driver code for queue 
    }
    
    public int pop() {
        if (!s2.isEmpty()){
            return s2.pop();
        }
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }
    
    public boolean empty() { // check all elements in queue - ie. elements stored in BOTH stacks
        return (s1.isEmpty() && s2.isEmpty()); // only if both stacks are empty is the queue empty
    }

    //Driver code
    public static void main(String[] args) 
    {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.pop(); // 1
        obj.push(4);
        obj.push(5);
        obj.pop(); // 2
        obj.pop(); // 3
        obj.peek(); 
        obj.empty();        
    } 
}