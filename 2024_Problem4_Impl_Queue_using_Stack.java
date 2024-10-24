//232. Implement Queue using Stacks - https://leetcode.com/problems/implement-queue-using-stacks/description/
//Time Complexity: All operation takes constant time O(1)
//Space Complexity: O(n)

class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> reverseStack;

    public MyQueue() {
        this.stack = new Stack<>();
        this.reverseStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);                      // Push element x to the end
    }

    private void reverseStack(){
        while(!stack.empty()){
            reverseStack.push(stack.pop()); //pop elements from main stack and push in reverseStack in reverse order
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int popElement = -1;                //default value of stack if empty

        if(reverseStack.empty())
            reverseStack();                 //populate the reverse stack

        popElement = reverseStack.pop();    //poping the first element in queue
        return popElement;
    }

    /** Get the front element. */
    public int peek() {
        int peekElement = -1;               //default value if stack is empty

        if(reverseStack.empty())
            reverseStack();                 //populate the reverse stack

        peekElement = reverseStack.peek();  //peeking the first element in queue w/o poping
        return peekElement;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (stack.empty() && reverseStack.empty());
    }
}