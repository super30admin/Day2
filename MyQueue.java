// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyQueue {

    Stack<Integer> peekpopStack;
    Stack<Integer> pushStack;
    int front;
	
    public MyQueue() {
        pushStack = new Stack<>();
        peekpopStack = new Stack<>();
        front = Integer.MAX_VALUE;
    }
    
	// setting front just to keep track of the first element inserted if the push stack isempty and if has already the elements we just push
    public void push(int x) {
        if (pushStack.empty())
            front = x;
        pushStack.push(x);
    }
    
	// is the second stack is empty we pop all the first stack elements and put into the second stack by which we can pop the first inserted element and peekstack contains all the elements now with push stack (first stack) empty
    public int pop() {
        if(peekpopStack.isEmpty())
            while(!pushStack.isEmpty()){
                peekpopStack.push(pushStack.pop());
            }
        
        return peekpopStack.pop();
    }

	//if the peek stack is not empty that means the topmost element would be the first element inserted else we can just return the front element
    public int peek() {
        if(!peekpopStack.isEmpty())
            return peekpopStack.peek();
        return front;
    }
    
	// here key is to check both the stacks if it has elements or not
    public boolean empty() {
        return pushStack.isEmpty() && peekpopStack.isEmpty();
    }
}
