// Time Complexity : O(1) to push the element. O(1) to pop and peek
// Space Complexity : O(n) as we are using two elements to push and then to reverse the order to get FIFO like use case of Queue
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this

class QueueUsingStack{

    Stack<Integer> st1;
    Stack<Integer> st2;

    public QueueUsingStack(){
        st1 = new Stack();
        st2 = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return st2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (st2.isEmpty()){
            while (!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}

/*
Leetcode analysis:
20 / 20 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 36.7 MB
 */