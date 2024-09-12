// Time Complexity : 
//   Push: O(1)
//   Pop: O(1) Worst Case: O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
  // Push elemnt to the stack
    public void push(int x) {
        in.push(x);
    }
    
  // When we see pop, check whether stack2 is empty or not
  // If empty, push all the elements from stack1 to stack2 and make stack1 empty
  // then perform pop on stack2.
    public int pop() {
        // if(out.isEmpty()) {
        //     while(!in.isEmpty()){
        //         out.push(in.pop());
        //     }
        // }
        peek();
        return out.pop();
    }
  
  
   // When we see pop, check whether stack2 is empty or not
  // If empty, push all the elements from stack1 to stack2 and make stack1 empty 
  // Then get the top value from stack2
    public int peek() {
         if(out.isEmpty()) {
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
  // Check both the stack elements
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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
