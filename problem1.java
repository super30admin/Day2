/* 
Time Complexity: 
Push & isEmpty -> O(1)
Pop % Peek -> O(N) where n is the number of elements in stack 
Space Complexity: O(n) where n is the number of elements in stack
*/


class MyQueue {

    //two stacks are used in order to actually perfom peek and pop 
    Stack<Integer> stack ; 

    //this is used to reverse the order of elements according to the queue
    Stack<Integer> queue ; 
    
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>() ; 
        queue = new Stack<>() ; 
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //we simply push the element 
        stack.push(x) ; 
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        //adding to queue stack in order to get the first inserted element on the top of the stack, that way, it behaves like a queue
        while (!stack.isEmpty())
        {
            int first = stack.peek() ; 
            queue.push(first) ; 
            stack.pop(); 
        }

        //getting the first inserted element 
        int ans = queue.peek(); 
        queue.pop() ; 

        //resetting the stack for other operations 
        while (!queue.isEmpty()) {
            int lifo = queue.peek() ;
            stack.push(lifo) ; 
            queue.pop(); 
        }
        
        return ans; 
    }
    
    /** Get the front element. */
    public int peek() {
    //to get the first inserted element on the top of the stack
      while (!stack.isEmpty())
        {
            int first = stack.peek() ; 
            queue.push(first) ; 
            stack.pop(); 
        }
        
        //getting the first element of the queue 
        int ans = queue.peek(); 
        
        //restting for the other operations 
        while (!queue.isEmpty()) {
            int lifo = queue.peek() ;
            stack.push(lifo) ; 
            queue.pop(); 
        }
        
        //returning the ans 
        return ans ; 
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        //we return when stack is empty, i.e. no elements present 
        return (stack.isEmpty()) ; 
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