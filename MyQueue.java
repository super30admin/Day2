//Time Complexity: For push O(1), For pop and peek, Amortized O(1) and worst case O(1)
//Space complexity: O(n) as extra stacks are needed
class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popAndPeekStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new Stack<Integer>();
        popAndPeekStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        pushStack.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        if (!popAndPeekStack.isEmpty())
            return popAndPeekStack.pop();
        else {

            while (!pushStack.isEmpty()) {
                popAndPeekStack.push(pushStack.pop());
            }
        }
        return popAndPeekStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!popAndPeekStack.isEmpty())
            return popAndPeekStack.peek();
        else {

            while (!pushStack.isEmpty()) {
                popAndPeekStack.push(pushStack.pop());
            }
        }
        return popAndPeekStack.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        return (popAndPeekStack.isEmpty() && pushStack.isEmpty());

    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */