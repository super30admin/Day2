// TC : TC for push operation is O(n),  for pop, empty, peek operation is O(1)
//SC : SC for push operation is O(n), for pop, empty,peek operation is O(1)

import java.util.Stack;

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public void print() {
        System.out.println(s1);
        System.out.println(s2);
    }
}
//Driver Code
class QueueWithStack { 
    public static void main(String args[]) 
    {
        MyQueue obj = new MyQueue();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);

        obj.print();
        System.out.println("\n Front Elem: "+obj.peek());
        System.out.println("\n Popped: "+obj.pop());
        System.out.println("\n Is empty: "+obj.empty());
        obj.push(50);

        obj.print();
    } 
}

/**
Output:

[10, 20, 30, 40]
[]

 Front Elem: 10

 Popped: 10

 Is empty: false
[50]
[40, 30, 20] */