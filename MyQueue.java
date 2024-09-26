import java.util.Stack;

class MyQueue {

    Stack<Integer> st;
    Stack<Integer> auxst;
    /** Initialize your data structure here. */
    public MyQueue() {
        st = new Stack<>();
        auxst = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!st.isEmpty()){
            int i = st.pop();
            auxst.push(i);
        }
        st.push(x);
        while(!auxst.isEmpty()){
            int k = auxst.pop();
            st.push(k);
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return st.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        int frontelement = st.pop();
        st.push(frontelement);
        return frontelement;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(st.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);

        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.peek();
        System.out.println(param_3);
        boolean param_4 = obj.empty();

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