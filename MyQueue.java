import java.util.*;


class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        
        stack1 = new Stack<>();
        stack2 =  new Stack<>();

    }
    
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public void push(int x) {
        
        if(stack1.isEmpty())
        {
            stack1.push(x);
        }
        else{
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
            stack1.push(x);

            while(!stack2.isEmpty())
            {
                stack1.push(stack2.pop());
            }
        }

    }
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public int pop() {
        
        return stack1.pop();
    }
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public int peek() {
        
        return stack1.peek();
    }
    
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    public boolean empty() {
        
        return stack1.size()==0;
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