// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes

class MyQueue {
      
    public MyQueue() {
      Stack<Integer> s1 = new Stack<Integer>();
      Stack<Integer> s2 = new Stack<Integer>();

    }
    
    public void push(int x) {
        s1.push();
        
    }
    
    public int pop() {
        int x;
        if(s1.isEmpty()){
            System.out.println("Queue is empty");
        }
        else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }     
            x=s2.peek();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
    }
    
    public int peek() {
        s1.peek();
        
    }
    
    public boolean empty() {
        return s1.isEmpty();
        
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
