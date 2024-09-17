// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// implement queue using stack 

class MyQueue {
    private Stack<Integer> pushst;
    private Stack<Integer> popst;
    int top;

    public MyQueue() {
        
        pushst = new Stack<>();
        popst = new Stack<>();
        top = -1;
        
    }
    
    public void push(int x) {
         top++;
        pushst.push(x);
       
        
    }
    
    public int pop() {
        while(top!=-1)
        {
        popst.push(pushst.pop());
            top--;
        }
        
        return popst.pop();
              
    }
    
    public int peek() {
        while(top != -1)
        {
        popst.push(pushst.pop());
            top--;
        }
        
        return popst.peek();
        
    }
    
    public boolean empty() {

        return popst.isEmpty();
        
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