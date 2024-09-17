//SC: O(1)
class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    private int front;
    public MyQueue() {
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
    }
    
    public void push(int x) { //O(1) - amortized and O(1)
        if(st1.isEmpty()){
              front = x;
        }
      
        st1.push(x);
        
    }
    
    public int pop() { //O(n)
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                 st2.push(st1.pop());
            }
          
        }
        return st2.pop();
    }
    
    public int peek() { //O(1)
       
            if(!st2.isEmpty()){
                return st2.peek();
            }
        return front;
    }
    
    public boolean empty() { //O(1)
        return st1.isEmpty() && st2.isEmpty();
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