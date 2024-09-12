import java.util.Stack;

// TC : TC for push operation is O(n),  for pop, empty, peek operation is O(1)
//SC : SC for push operation is O(n), for pop, empty,peek operation is O(1)
class MyQueue {

    private Stack<Integer> st1;
    private Stack<Integer> st2;


    /** Initialize your data structure here. */
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        // the latest element added should be at the bottom of the stack. Hence we use another stack to store the reverse order temporarily and then add it back to original stack after adding the new element
        while(!st1.empty())
            st2.push(st1.pop());
        st2.push(x);
        while(!st2.empty())
            st1.push(st2.pop());

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return  st1.pop();
    }


    /** Get the front element. */
    public int peek() {
        return st1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.empty();
    }

    public static  void main (String args[])
    {
        MyQueue myQueue = new MyQueue();
        myQueue.push(5);
        myQueue.push(10);
        myQueue.push(15);

        System.out.println("The front element is :" +myQueue.peek()); //5

        System.out.println("The popped element is :" +myQueue.pop()); //5

        System.out.println("The front element after popping is :" +myQueue.peek()); //10
        myQueue.pop();
        System.out.println("The queue is Empty? :" +myQueue.empty()); //false
        myQueue.pop();
        System.out.println("The queue is Empty? :" +myQueue.empty()); //true


    }
}