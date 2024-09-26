class MyQueue {
    
    private Stack<Integer> first;
    private Stack<Integer> second;
    private int front;
    public MyQueue() {
        this.first = new Stack();
        this.second = new Stack();
    }
    
    //Time Complexity : O(1)
    //Space Complexity : O(1)
    public void push(int x) {
    if(first.isEmpty())
        front = x;    
    first.push(x);
    }
    
    //Amortized Time Complexity : O(1)
    public int pop() {
    if(second.isEmpty()){
        while(!first.isEmpty()){
            second.push(first.pop());
        }
    }
       return second.pop();
    }
     //Time Complexity : O(1)
    public int peek() {
       if(!second.isEmpty())
            return second.peek();
        
        return front;
    }
     //Time Complexity : O(1)
    public boolean empty() {
        return first.isEmpty() && second.isEmpty() ;
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
