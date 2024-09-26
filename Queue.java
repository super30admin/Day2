// Time Complexity :O(1)
// Space Complexity :O(n) n-elements added in the stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Understanding the idea took me a while


// Using Two stack
class MyQueue {
    
	//create two stack
    Stack<Integer> first;
    Stack<Integer> second;
    /** Initialize your data structure here. */
    public MyQueue() {
        first=new Stack<>();
        second=new Stack<>(); 
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
		
        first.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
		//Now we need to make LIFO to FIFO which is necessary in both peek and pop. so I implemented it in peek
		//call peek // reusing the code
        peek();
        return second.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
		//The initial stack elements will be added to the second stack which makes them to be in FIFO format now in second stack
		//Initially second stack will be empty and so it will have the popped elements from first stack
		//If a push is called after a pop or a peek, the new elements will remain in first stack until all the elements in second stack is popped
        if(second.isEmpty())
        {
            while(!first.isEmpty())
            {
                second.push(first.pop());
            }
        }
        return second.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
		
        return first.isEmpty() && second.isEmpty();
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