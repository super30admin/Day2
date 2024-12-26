// Time Complexity : Empty & push - O(1) -- Pop and peek - Average is O(1) and worst is O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
import java.util.Stack;

class MyQueue {
    // Declaring two stacks
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        // Initializing stacks
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
        // Simply push in stack 1
        s1.push(x);
    }

    public int pop() {
        /*
         * First check is s2 is empty, push all values from s1 to s2, that will reverse
         * the order in s2 - O(n). Then simply pop from s2.
         * If s2 not empty, then simply pop from s2 - O(1)
         */
        peek();
        return s2.pop();
    }

    public int peek() {
        /*
         * First check is s2 is empty, push all values from s1 to s2, that will reverse
         * the order in s2 - O(n). Then simply peek from s2.
         * If s2 not empty, then simply peek from s2 - O(1)
         */
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        // If both s1 and s2 are empty then we can say that queue is empty
        return s1.isEmpty() && s2.isEmpty();
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