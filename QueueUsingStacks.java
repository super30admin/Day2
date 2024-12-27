// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        this.in = new Stack<Integer>();
        this.out = new Stack<Integer>();
    }
    //O(1)
    public void push(int x) {
        in.push(x);
        
    }
    //O(n)
    public int pop() {
         peek();
        return out.pop();

        
    }
  //O(n)
    public int peek() {
       if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }

        return out.peek();
        
    }
    
    public boolean empty() {

        return(in.isEmpty() && out.isEmpty());
        
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