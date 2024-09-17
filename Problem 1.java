
class MyQueue {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(out.isEmpty()){
            while (!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    /** Getting the front element. */
    public int peek() {
        if(out.isEmpty()){
             while(!in.isEmpty())
             {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns true if the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}