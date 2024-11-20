// o(2n) space complexity
//amortized o(1) time complexity

class MyQueue {
    
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int front = -1;
    public MyQueue() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }
    
    public void push(int x) {
        if(stack1.empty())
            front = x;
        stack1.push(x);
    }
    
    public int pop() {
//         while(stack1.empty()==false)           /// naive approach
//         {
//             stack2.push(stack1.pop());
//         }
//         int temp = stack2.pop();
        
//         while(stack2.empty()==false)
//         {
//             stack1.push(stack2.pop());
//         }
//         return temp;
        if(stack2.empty())             /////amortized approach
        {
            while(stack1.empty()==false){             
                stack2.push(stack1.pop());               ///// push stack1 contents into stack2 when stack2 is empty
            }
            
        }
        return stack2.pop();   //// keep popping from the stack2 only since the front elements are here in order
        
    }
    
    public int peek() {
//         while(stack1.empty()==false)          ////naive approach
//         {
//             stack2.push(stack1.pop());
//         }
//         int temp = stack2.peek();
        
//         while(stack2.empty()==false)
//         {
//             stack1.push(stack2.pop());
//         }
//         return temp;
        if(!stack2.empty())                          //// amortized approach
        {
            
            return stack2.peek(); 
        }
        return front;
    }
    
    public boolean empty() {
        return stack1.empty() && stack2.empty();
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
