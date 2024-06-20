/*
Time Complexity:
    1. Push : 0(1)
    2. Pop  : 0(1) for most of the case.
              0(k) when stablize function is called.
    3. Peek : 0(1) for most of the case.
              0(k) when stablize function is called.
    3. Empty: 0(1)

Space Complexity: 0(n) where n is the total number of elements in both stacks

Approach:
1. Consider two stacks, primary and secondary stack
2. For every push to queue operation, push the elements to the stack in the primary stack
3. For every pop operation, like in queue (assume) we need to remove element from the front of the queue.
Therefore we need to make sure to call a function called "stablize" which will push all the elements in the
queue from the primary stack to the secondary stack & then will pop the element from the stack present in
the socondary array. Similary perform for peek operation as well.
 */

class MyQueue {

    /* Given that all the stack function calls will be done on the valid stack */
    private Stack<Integer> primaryStack;
    private Stack<Integer> secondaryStack;

    public MyQueue() {
        this.primaryStack = new Stack<>();
        this.secondaryStack = new Stack<>();
    }

    public void push(int x) {
        // just add to the primaryStack
        this.primaryStack.push(x);
        return;
    }

    private void stablizeStack(){
        // base-case
        if (this.secondaryStack.size() != 0){
            return;
        }

        // logic-case
        while (this.primaryStack.size() != 0){
            this.secondaryStack.push(this.primaryStack.pop());
        }

        return;
    }

    public int pop() {
        // visualize queue, you pop element from the front of the queue. So push all the elements inside
        // the secondary stack from the primary stack if secondary stack is empty
        this.stablizeStack();
        return this.secondaryStack.pop();
    }

    public int peek() {
        this.stablizeStack();
        return this.secondaryStack.peek();
    }

    public boolean empty() {
        if (this.primaryStack.size() == 0 && this.secondaryStack.size() == 0){
            return true;
        }
        return false;
    }
}
