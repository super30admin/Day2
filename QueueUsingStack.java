// Time Complexity :
// push - O(1)
// pop - O(N) worst case. O(1) avg case
// peek - O(N) worst case. O(1) avg case
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {

    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;

    public MyQueue() {
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
    }

    public void push(int x) {
        stackOne.push(x);
    }

    public int pop() {
        if (!stackTwo.isEmpty())
            return stackTwo.pop();
        else {
            while(!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
            return stackTwo.pop();
        }
    }

    public int peek() {
        if (!stackTwo.isEmpty())
            return stackTwo.peek();
        else {
            while(!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
            return stackTwo.peek();
        }
    }

    public boolean empty() {
        if (stackOne.isEmpty() && stackTwo.isEmpty())
            return true;
        return false;
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