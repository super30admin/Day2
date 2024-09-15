//time complexity is o(n)
//space complexity is o(n)
//passed all leetcode cases
//using two stacks to acheive fifo. push into one stack and while pop is being performed all the elements will be pushed in to second stacks after pop from first.


class MyQueue {
    Stack<Integer> main;
    Stack<Integer> secondary;

    /** Initialize your data structure here. */
    public MyQueue() {
        main = new Stack<>();
        secondary = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        main.push(x);


    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(secondary.isEmpty()&&main.isEmpty()){
            return -1;
        }
        if(!secondary.isEmpty()){
            return secondary.pop();

        }
        while(!main.isEmpty()){
            int x = main.pop();
            secondary.push(x);
        }
        return secondary.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(secondary.isEmpty()&&main.isEmpty()){
            return -1;
        }
        if(!secondary.isEmpty()){
            return secondary.peek();

        }
        while(!main.isEmpty()){
            int x = main.pop();
            secondary.push(x);
        }
        return secondary.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(secondary.isEmpty()&&main.isEmpty()){
            return true;
        }
        else{
            return false;
        }
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