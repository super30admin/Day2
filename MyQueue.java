// Time Complexity :
    // Push operation : O(1), as we simply insert elements in stack1
    //Pop operation :   O(n), as we pop all elements from s1 and push to s2. Then return the top of s2.
    //Peek operation : O(n), same as pop

// Space Complexity : O(n1) + O(n2), n1 and n2 are size of 2 stacks used.

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;


    /** Initialize your data structure here. */
    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int pop = s2.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return pop;
    }

    /** Get the front element. */
    public int peek() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int peek = s2.peek();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(x);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.peek();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
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