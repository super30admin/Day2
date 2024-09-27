//Time Complexity: O(1)
//Space Complexity: O(1)

import java.util.Stack;
class MyQueue {
    //Create 2 stacks for push and pop/peek operations.
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        //push all elements into the 'in' stack
        in.push(x);
    }
    
    public int pop() {
        //pop elements from 'in' stack and push those into 'out' stack and return the element by popping 'out' stack. So FIFO.
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    public int peek() {
        //Same as Push, peek the element from 'out' stack after popping all elements from 'in' stack.
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        //Checking both 'in' and 'out' stacks are empty or not.
        if(in.isEmpty() && out.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}