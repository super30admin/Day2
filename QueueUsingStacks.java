// in this implementation we will be using two stacks. One to store the elements that are pushed into the Queue. The outer stack is used to store the elements that would be going out of the stack. This wasy would be able to acheieve the basic functionality of the queue that is First in First out.

// Time complexity: 
// push - O(1)
// pop and peek - O(n) worst case as we would be popping all the elements in the instack into the outstack for popping and peeking the first element.
// Space Complexity:Two stacks would consume O(n) space complexity.

class QueueUsingStacks {
    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public QueueUsingStacks() {
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();
        
    }
    
    public void push(int x) {
        inSt.push(x);
    }
    
    public int pop() {
        if(outSt.empty()){
            while(!inSt.empty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.pop();
        
    }
    
    public int peek() {
        if(outSt.empty()){
            while(!inSt.empty()){
                outSt.push(inSt.pop());
            }
    }
        return outSt.peek();
        
    }
    
    public boolean empty() {
        return inSt.empty() && outSt.empty();
        
    }
}