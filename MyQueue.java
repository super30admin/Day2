//Time Complexity -
  //1. Push - O(1)
  //2. Pop - O(N)
  //3. Peek - O(N)
  //4. Empty - O(1)

//Space Complexity - O(N)

class MyQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack();
        popStack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
