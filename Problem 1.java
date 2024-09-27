// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes  
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer>s1;
    Stack<Integer>s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty())
        {
            while(!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty())
        {
            while(!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty())
        {
            return true;
        }
        else
        {
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