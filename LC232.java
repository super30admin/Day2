// TC: push():O(1), pop() and peek():Amortized O(1), empty():O(1)
// SC: O(n) where n is the max number of consecutive pushes

import java.util.Stack;

class MyQueue {

    Stack<Integer> s1, s2;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void transfer(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        transfer();
        return s2.pop();
    }
    
    public int peek() {
        transfer();
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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