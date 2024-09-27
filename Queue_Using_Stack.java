// Time Complexity : Push()-> O(1), Pop() -> Amortized Cost = O(1) => The first operation will take O(n). After that we can pop at O(1). 
//                    We will have few/rare O(n) operations only when Stack 2 is empty.
// Space Complexity : O(n) as we are using 2 stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was initially putting back the elements from Stack 2 to stack 1 after one pop but later I realised
//                                            that it is not necessary.


// Your code here along with comments explaining your approach
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> pushop;          // One stack for Push operations / Enqueue
    Stack<Integer> popop;           // One Stack for Pop Operations/ Dequeue
    public MyQueue() {
        pushop = new Stack<>();
        popop = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
     pushop.push(x);                // Pushing into the Push Stack
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!popop.empty()){             // If Pop Stack has elements, simply pop the top 
            return popop.pop();
        } else {
         while(!pushop.empty()){            // Else Transfer everything from Push Stack to Pop Stack and return the top of the Pop Stack
             int out = pushop.pop();
             popop.push(out);
         }
        int out_of_stack = popop.pop();
        return out_of_stack;
        }
    }
    
    /** Get the front element. */
    public int peek() {
            if(!popop.empty()){
            return popop.peek();        // If Pop Stack has elements , simply peek the top 
        } else {
          while(!pushop.empty()){           // Else Transfer everything from Push Stack to Pop Stack and return the top of the Pop Stack
             popop.push(pushop.pop());
         }
        int top = popop.peek();
        return top;
            }
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(pushop.empty() && popop.empty()){  // When both the stacks are empty indicates we dont have any more elements to process
            return true;
        } else {
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