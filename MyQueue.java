// Time Complexity : push: O(1) pop: Amortised O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Use 2 stacks. Whne there is push, add element into stack 1, when there is pop, remove element from stack 2. In the pop operation,
 * is stack 2 is empty, we move all elements from stack 1 to stack 2 and then do pop from stack 2, else simply do pop from stack 2. 
 * This gives Amortised O(1) time complexity for pop operation. Peek will return top element of stack2. In case stack 2 is empty, 
 * it should return the bottom most element in stack 1. We use front variable to store that.
 * @author puppalwar
 *
 */
class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;

    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        if(s1.isEmpty()){
            front=x;
        }
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }
        return front;
    }
    
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()){
            return true;
        }
        return false;
    }
    
    // Driver code 
    public static void main(String[] args) 
    { 

	//MyQueue object will be instantiated and called as such:
	   MyQueue obj = new MyQueue();
	   obj.push(x);
	   int param_2 = obj.pop();
	   int param_3 = obj.peek();
	   boolean param_4 = obj.empty();
    } 
       
}