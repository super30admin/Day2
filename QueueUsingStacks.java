import java.util.Stack;
class QueueUsingStacks {

    //two stacks are used to implement queue, one stack is used for push operation and another stack is used for pop and peek operation
    Stack<Integer> in;
    Stack<Integer> out;

    public QueueUsingStacks() {
        in = new Stack<>();
        out = new Stack<>();
    }

    //time complexity O(1)
    //push the element in the in stack
    public void push(int x) {
        in.push(x);
    }
    
    //time complexity is O(n) because of peek function in the worst case, amortized time complexity is O(1)
    //pop the element from the out stack
    public int pop() {
        peek();
        return out.pop();
    }
    
    //time complexity is O(n) because of peek function in the worst case, amortized time complexity is O(1)
    //get the element from the out stack
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    //time complexity O(1)
    //check if the queue is empty by checking if both stacks are empty
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