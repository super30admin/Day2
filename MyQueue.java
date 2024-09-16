// Time Complexity : O(1)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyQueue {

    Stack st;
    Stack st2;
    public MyQueue() {
        st = new Stack(); //creating stack 1
        st2 = new Stack(); //creating another stack to push the elements to that stack if there is a pop operation
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        if(st2.empty()){
            while(!st.empty()){      //pushing stack1 elements to stack2 to implement queue pop operation
            st2.push(st.pop());
            }
        }
        return (Integer)st2.pop();
    }
    
    public int peek() {
        if(st2.empty()){
            while(!st.empty()){     //pushing stack1 elements to stack2 to implement queue peek operation
            st2.push(st.pop());
            }
        }
            return (Integer)st2.peek();
    }
    
    public boolean empty() {
        if(st.empty() && st2.empty())
            return  true;
        else
            return false;
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