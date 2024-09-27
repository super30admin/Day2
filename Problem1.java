// Time Complexity : push - O(1), pop - amortized - O(n), peek - O(n), isEmpty - O(1)
// Space Complexity : auxillary space - O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initializing the queue using two stacks that take integers. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. stack1 is used for all
     * push operations and takes O(1) as a normal stack push operation  */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element.
     * We use the stack2 for all pop operations, if stack2 is empty that means
     * we need to add elements from stack 1 to stack2 (gets added in reverse order).*/
    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            return -1;
        }
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    /** Get the front element.
     * Peek will also take same time as pop beacuse if stack2 is
     * empty we have to add all elements from stack1 to stack2.
     * If both stacks are empty we return -1 */
    public int peek() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            return -1;
        }
        if(!stack2.isEmpty()){
            return stack2.peek();
        }else{
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

    /** Returns whether the queue is empty.
     * This function takes normal O(1) time as a normal empty operation on stack.
     * We need to check if both stacks are empty as at any point in time if the queue
     * is not empty then there is atleast one element in either stack1 or stack 2*/
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
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