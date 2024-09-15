// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :1. I was initializing stack inside constructor which did not work. I am not getting the point here,why do I have to initialize outside the class
// 2.Pushing new element to stack2 was key here which I was not getting


// Your code here along with comments explaining your approach
/*
We can use 2 stacks
Push operation: We have to move all the elements from s1->s2,then again from S2->S1 now top,peek of the stack is first element
time complexity: O(n)
space complexity: O(n)
pop operation: we can just pop first element from s1 and it will be the first element of the queue.
time complexity: O(1)
space complexity: O(n)

for peek and isEmpty operations space,time complexity is O(1)
 */

class MyQueue {

    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();
    int peek;

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        while(!stack1.isEmpty())
            stack2.push(stack1.pop());

        stack2.push(x);

        while(!stack2.isEmpty())
            stack1.push(stack2.pop());

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int no=-1;
        if(!stack1.isEmpty())
        {
            no=stack1.pop();
        }
        return no;
    }

    /** Get the front element. */
    public int peek() {
        if(!stack1.isEmpty())
            return stack1.peek();
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
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