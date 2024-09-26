// Time Complexity :O(1)-Amortized
      push-O(1),pop-O(1),top-O(n)              
// Space Complexity :O(2n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No




// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> St1,St2;      //Declaration     

    public MyQueue() {
        St1 = new Stack();      //Object creation
        St2 = new Stack();      //Object creation
    }
    
    public void push(int x) {
        St1.push(x);             //push the elements to stack
        
    }
    
    public int pop() {
        while(St1.size() > 1)        
        {
            St2.push(St1.pop());    //pop the elements from stack1                                      
        }
        int data = St1.pop();       //Store the poppped element 
        while(!St2.isEmpty())
        {
            St1.push(St2.pop());     //pop elements from stack2 and push the elemets                                       //to stack1
        }
        return data;                //return the stored element
    }
    
    public int peek() {
        while(St1.size() > 1)
        {
            St2.push(St1.pop());     
        }
        int data = St1.peek();      //stores the top most element
        while(!St2.isEmpty())
        {
            St1.push(St2.pop());
        }
        return data;                 //returns the stored element
        
    }
    
    public boolean empty() {
        return St1.size() == 0 ;    //returns true or false
        
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
