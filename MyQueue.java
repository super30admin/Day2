//Time Complexity:O(1)
//Space Complexity:O(1)

class MyQueue {
    Stack<Integer> st;
    Stack<Integer> minStack;
    public MyQueue() {
        st=new Stack();
        minStack=new Stack();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        peek();
        int res=minStack.pop();
        return res;
    }
    
    public int peek() {
        if(minStack.isEmpty()){
            while(!st.isEmpty()){
                minStack.push(st.pop());
            }
        }
        return minStack.peek();
    }
    
    public boolean empty() {
        if(st.isEmpty() && minStack.isEmpty()){
            return true;
        }
        return false;
    }
}

