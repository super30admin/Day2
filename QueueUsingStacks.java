import java.util.Stack;
//Time Complexity: O(n)
// Space Complexity: O(n)
public class QueueUsingStacks
{
    Stack<Integer> input;
    Stack<Integer> output;
    public QueueUsingStacks() {
        input = new Stack<>();
        output = new Stack<>();
    }

    //O(1)
    public void push(int x) {
        input.push(x);
    }
    //O(N)
    public int pop() {
        peek();
        return output.pop();
    }
    //O(N)
    public int peek() {
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
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