/*
 Time Complexity - Push O(1), Pop O(n)
 Space Complexity - Push O(n), Pop O(1)
 */


 /*
  In push operation, the new element is always enqueued to s1. 
  In pop() operation, if s2 is empty then all the elements are moved to s2 in reverse order of insertion 
  and the top element is popped.
  */
public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        peek();
        return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
