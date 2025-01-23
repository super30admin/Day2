// Time Complexity : push operation O(1), pop operation O(1) best case worse case O(n)
// Space Complexity : O(N) + O(N) == O(N)
// Did this code successfully run on Leetcode : yes it did the edge case is not covered if the peek() is called when the list is empty then peek() and pop() will throw an error
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach


package queue;

import java.util.Stack;

public class QueueUsingStacks {

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
//         error case needs to be handled
//        System.out.println(queue.pop());
//        System.out.println(queue.peek());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        System.out.println(queue.empty());
        queue.pop();
        System.out.println(queue.empty());
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.empty());
    }

    private Stack<Integer> input;
    private Stack<Integer> output;

    public QueueUsingStacks() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();

        return output.pop();
    }

    public int peek() {

        if (output.isEmpty()) {

            if (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
