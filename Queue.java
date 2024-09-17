// Time Complexity :
//push operation :O(1)
//peek operation :O(n)
//pop operation :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :mapping the the midpoint element to matrix.


// Your code here along with comments explaining your approach

//We can inmplement th solution using two stacks
class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        inStack=new Stack<Integer>();
        outStack=new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!outStack.isEmpty()){
            return outStack.pop();
        }else{
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!outStack.isEmpty()){
            return outStack.peek();
        }else{
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(inStack.isEmpty() && outStack.isEmpty()){
            return true;
        }else{
            return false;
        }
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
 
 //This is the brute force method using the two stacks.
 class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public MyQueue() {
        inStack=new Stack<Integer>();
        outStack=new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(!inStack.isEmpty()){
            while(!inStack.isEmpty()){
                // System.out.println("hi");
                 int temp=inStack.pop();
                 outStack.push(temp); 
            }
        }
        //System.out.println("-"+outStack);
        inStack.push(x);
        if(!outStack.isEmpty()){
            while(!outStack.isEmpty()){
               inStack.push(outStack.pop()); 
            }
        }
        //System.out.println(inStack);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return inStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return inStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty();
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