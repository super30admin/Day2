class MyQueue {
    // Time complexity will be O(n)
    // Space complexity will be O(n)
    Stack<Integer> s1;
    Stack<Integer> s2;

    //Initialize your data structure here. 
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    // Push element x to the back of queue. 
    public void push(int x) {
        //push to s1
        s1.push(x);
    }
    
    // Removes the element from in front of queue and returns that element. 
    public int pop() {
        //pop from s2
        if(peek() != -1){
            return s2.pop();
        }
        return -1;
    }
    
    // Get the front element. 
    public int peek() {
        if(!empty()){
           if(s2.isEmpty()){
               while(!s1.isEmpty())
                    s2.push(s1.pop());
           }
           return s2.peek();
        }
        return -1;
    }
    
    // Returns whether the queue is empty. 
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty())
            return true;
        return false;
    }
}
