package Day2;

import java.util.Stack;

public class QueueUStack {

    /** Initialize your data structure here. */
    Stack<Integer> que = new Stack<>();
    Stack<Integer> temp = new Stack<>();

    public QueueUStack() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(que.isEmpty()){
            que.push(x);
        }
        else{
            while(!que.isEmpty()){
                temp.push(que.pop());
            }
            que.push(x);
            while(!temp.isEmpty()){
                que.push(temp.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!que.isEmpty()){
           return que.pop();
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        return que.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return que.isEmpty();
    }

    public static void main(String args[]){
        QueueUStack obj = new QueueUStack();

        System.out.println("Is Queue empty: "+obj.empty());

        System.out.println("Pushing elements");
        obj.push(2);
        obj.push(4);
        obj.push(6);
        obj.push(8);

        System.out.println("Is Queue empty: "+obj.empty());

        System.out.println("Peek: "+obj.peek());

        System.out.println("Pop: "+obj.pop());

        System.out.println("Peek: "+obj.peek());


    }
}
