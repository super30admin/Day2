class MyQueue {
    //Time complexity:O(1)
    //Space Complexity:O(n)
    Stack<Integer> st1=new Stack<>();
    Stack<Integer> st2=new Stack<>();
    //int top1=-1,top2=0;
    public MyQueue() {
        
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
       peek();  
        return st2.pop();
    }
    
    public int peek() {
        int r=0;
        if(!st2.isEmpty()){
            r=st2.peek();
        }
        else{
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            r=st2.peek();
        }
        return r;
    }
    
    public boolean empty() {
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
