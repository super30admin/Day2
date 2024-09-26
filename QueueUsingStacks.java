// Time Complexity : O(1) for push, amortized O(1) for pop
// Space Complexity :  O(n) where n is the number of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class QueueUsingStacks {
    Stack<Integer> in, out;

    public MyQueue() {
        //first stack for pushing elements
        in = new Stack();
        //second stack for popping elements
        out = new Stack();
    }

    public void push(int x) {
        //push the elemnt to the first stack
        in.push(x);
    }

    public int pop() {
        //If the second stack is empty, and the first stack is not empty, push everything from first stack to second stack
        // and pop the top element from the second stack
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();

    }

    public int peek() {
        //If the second stack is empty, and the first stack is not empty, push everything from first stack to second stack
        // and peek the top element from the second stack
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        // return true if both first and second stacks are empty
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