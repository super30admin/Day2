// Time Complexity : Pop and peek - Worst case - O(N) - Best case - O(1)
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int popped = s2.pop();
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return popped;
    }

    public int peek() {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int peek = s2.peek();
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return peek;

    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

