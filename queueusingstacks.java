// Time Complexity : push, empty: O(1), pop, peek: Amortized O(1), worst case O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out; //need two stacks, in stack to push elements, out stack to get first element pushed (fifo)
    
    public MyQueue() {
        in=new Stack<>();
        out=new Stack<>();
    }
    
    public void push(int x) { //push element to in stack
        in.push(x);
    }
    
    public int pop() { //
        peek();
        return out.pop();
    }
    
    public int peek() { //if out stack is empty pop from in stack to out stack then, return top element from out stack
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() { //check if both stacks are empty
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