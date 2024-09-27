TC: O(n)  Average TC : O(1)
SC: O(n)

Leetcode: Failing for this case "MyQueue","empty" while submission even though it is passing it in console

Approach:There should be 2 stacks.When we are pushing to stack, keep pushing to S1.While popping , see if S2 is empty or not.
If empty, pop all elements from S1 to S2 and pop. If S2 is not empty just pop.


class MyQueue {
    static Stack<Integer> s1 = new Stack<Integer>();  
    static Stack<Integer> s2 = new Stack<Integer>();  
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {

        s1.push(x);  
    }
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.isEmpty()){  
           while(!s1.isEmpty()) {
               s2.push(s1.pop());
           }
        }
      return  s2.pop();
       
    }
    
    /** Get the front element. */
    public int peek() {
         if (s2.isEmpty())  
        {  
           while(!s1.isEmpty()) {
               s2.push(s1.pop());
           }
        }
       return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
        
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
