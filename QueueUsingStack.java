// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class QueueUsingStack {
    public Stack<Integer> st1;
    public Stack<Integer> st2;
    

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
        
        
        
    }
    
    public void push(int x) {
        // all the elements we have to push into st1
        st1.push(x);
        
    }
    
    public int pop() {
        // we have to check wether the st2 is empty or not
        if(st2.isEmpty() ){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
          
        return st2.pop();
        
    }
    
    public int peek() {
         if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
         }
            return st2.peek();
         }
        
    
    
    public boolean empty() {
        return (st1.isEmpty() && st2.isEmpty());
        
    }
}