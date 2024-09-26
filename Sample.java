// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1=new Stack<Integer>();
        st2=new Stack<Integer>();
    }
    
    public void push(int x) {
       st1.push(x);
    }
    
    public int pop() {
        if(!st2.isEmpty())
            return st2.pop();
      else if(st2.isEmpty() && !st1.isEmpty()){
           while(!st1.isEmpty()){
               st2.push(st1.pop());
           }
           return st2.pop();
      }else
            return -1;
    }
    
    public int peek() {
        if(!st2.isEmpty())
            return st2.peek();
        else if(st2.isEmpty() && !st1.isEmpty()){
           while(!st1.isEmpty()){
               st2.push(st1.pop());
           }
            return st2.peek();
        }
        else
            return -1;
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
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
