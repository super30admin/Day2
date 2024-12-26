// Approach: Two stacks were used to maintain FIFO ordering using a LIFO stack. Push operation is made costly inorder to maintain O(1) pop. When a new
// element is pushed, all elements in one stack (with correct queue ordering) are transferred to empty stack. The new element is then pushed onto
// current stack, and all elements are copied back to the current stack. Thus, the new element, which entered last, is placed at the back of the queue.
// Time Complexity : O(n) for push, O(1) for pop and peek operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Deque;
import java.util.ArrayDeque;

public class QueueUsingStacks {
    Deque<Integer> stack1, stack2;

    QueueUsingStacks() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    // Enqueue operation - Add element to the end of the queue
    void push(int x) {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack2.push(x);
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        } else if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }

    // Dequeue operation - Remove and return element at front of the queue
    int pop() {
        if (empty()) {
            return -1;
        }
        if (stack1.isEmpty()) {
            return stack2.pop();
        }
        return stack1.pop();
    }

    // Return element at the front of the queue
    int peek() {
        if (empty()) {
            return -1;
        }
        if (stack1.isEmpty()) {
            return stack2.peek();
        }
        return stack1.peek();
    }

    // Returns true if queue is empty
    boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    void printQueue() {
        System.out.println("Order of queue elements printed - front to back");
        if (!stack1.isEmpty()) {
            for (int i : stack1) {
                System.out.println(i);
            }
        } else if (!stack2.isEmpty()) {
            for (int i : stack2) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks qus = new QueueUsingStacks();
        qus.push(10);
        qus.push(20);
        qus.push(30);
        qus.printQueue();
        System.out.println("Popped: " + qus.pop());
        System.out.println("Queue elements after dequeue operation...");
        qus.printQueue();
        System.out.println("Element at front of the queue: " + qus.peek());
    }
}