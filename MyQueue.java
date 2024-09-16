import java.util.Stack;

//Time Complexity=O(1)
//Space Complexity(n)
class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack=new Stack<Integer>();
        outStack=new Stack<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()){

            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();

    }

    public int peek() {
        if(outStack.isEmpty()){

            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }

        return outStack.peek();
    }

    public boolean empty() {

        return inStack.isEmpty() && outStack.isEmpty();
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