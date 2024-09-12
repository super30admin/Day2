/*
The amortized time complexity is O(1) and the space complexity is O(N) where N is the number of elements stored.

Here, the idea is to use two stacks to implement queue. One for insertion and the other for pop of peek. When we want to peek or pop and
the second stack is empty we pop each element from first stack and insert into the second stack.

Yes, the solution passed all the test cases in leetcode
 */
class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> queue;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        queue = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(queue.isEmpty()){
            while(stack.size()>0){
                queue.push(stack.pop());
            }
        }
        return queue.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(queue.isEmpty()){
            while(stack.size()>0){
                queue.push(stack.pop());
            }
        }
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty()&&stack.isEmpty();
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