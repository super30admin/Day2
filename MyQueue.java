import java.util.*;
class MyQueue {
    Stack <Integer> s1;
    Stack <Integer> s2;

    public MyQueue() {
        s1=new Stack();
        s2=new Stack();
    }

    public void push(int x)
    {
        s1.push(x);
    }

    public int pop()
    {
        peek();
        return s2.pop();

    }

    public int peek()
    {
        if(s2.isEmpty())
        {
            while(!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
        }
        return s2.peek();

    }

    public boolean empty()
    {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int param=myQueue.peek();
        int param1=myQueue.pop();
        System.out.println(param);
        System.out.println(param1);
        System.out.println(myQueue.empty());
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