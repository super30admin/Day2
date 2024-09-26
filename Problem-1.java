// Time Complexity : push- O(1), pop- O(1) amortized, peek - O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A

class MyQueue {
    
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    private int front;
    
    
    public MyQueue() {
        
    }
    
    //push to back of queue
    public void push(int x) {
        if (s1.empty())
             front = x;
        s1.push(x);
    }
    //reversing the elements in the stack and returning the top value
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
             s2.push(s1.pop());
        }
    return s2.pop(); 
    }
    //checking if the second stack has elements else returning the front element
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
