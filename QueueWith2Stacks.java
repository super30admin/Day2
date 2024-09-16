import java.util.ArrayDeque;
import java.util.Deque;

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/**
 * Algo:
 * 
 * Queue = FIFO
 * Stack = LIFO
 * 
 * Here, intent is to use a Stack's (can use in-built) properties to implement
 * the FIFO functionality
 * 
 * Queue.offer() == Stack.push()
 * 
 * Queue.poll() != Stack.pop() => we've to pop all elements from the stack till
 * the stack is empty => but we've to hold the other popped elements (except the
 * last which is to be popped) => hence, use a 2nd Stack to store these popped
 * elements
 * Now, when we have to Queue.pop(), we always first start with the 2nd stack,
 * if it is empty => repeat the above process
 * 
 * Similarly, Queue.peek() != Stack.peek()
 * 
 * Queue.empty() => if both the stacks are empty
 */
/**
 * Time Complexity :
 * 
 * push(): O(1)
 * pop(): Amortized O(1)
 * peek(): Amortized O(1)
 * empty(): O(1)
 */
/**
 * Space Complexity :
 * 
 * Overall: O(n)
 * 
 * push(): O(1)
 * pop(): Amortized O(1)
 * peek(): Amortized O(1)
 * empty(): O(1)
 */

public class QueueWith2Stacks {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public QueueWith2Stacks() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int num) {
        stack1.push(num);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            pushToStack2();
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }

    private void pushToStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int peek() {
        if (stack2.isEmpty()) {
            pushToStack2();
        }
        return stack2.isEmpty() ? -1 : stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}