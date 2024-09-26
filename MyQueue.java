// Time Complexity :o(1)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no 
import java.util.Stack;

public class MyQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    int front_val;
    
    public void push(int data)
    {
        front_val = data;
        while (!s1.empty())
        {
            s2.push(s1.pop());
        }
        s2.push(front_val);
        while (!s2.empty())
        {
            s1.push(s2.pop());
        }
    }
    public int pop()
    {
        if (!s1.empty())
            return s1.pop();
        else
            return -1;
    }
    public int peek()
    {
        if (!s1.empty())
            return s1.peek();
        else
            return -1;
    }
    public boolean empty()
    {
        if (s1.empty())
            return true;
        else
            return false;
    }
    public static void main(String[] args)
    {
        MyQueue loke = new MyQueue();
        loke.push(1);
        loke.push(2);
        loke.push(3);
        System.out.println(loke.peek());
        System.out.println(loke.pop());
        System.out.println(loke.peek());
        System.out.println(loke.pop());
        loke.push(4);
        System.out.println(loke.pop());
        System.out.println(loke.peek());
    }
}