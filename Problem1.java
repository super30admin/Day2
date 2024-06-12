import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(1)
class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        this.peek();
        return outStack.pop();
    }
    
    public int peek() {
        if (outStack.isEmpty()) {   // if outStack is empty then pop all elements from inStack and push to outStack
            while(!inStack.isEmpty()) {
                int popped = inStack.pop();
                outStack.push(popped);
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

public class Problem1 {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_4);
        System.out.println(param_3);
    
    }
}
