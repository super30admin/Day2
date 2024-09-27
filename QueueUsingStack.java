// Time Complexity : O(1) for every operation, amortized for push
// Space Complexity : O(n) n is size of queue
// Did this code successfully run on Leetcode : yes
import java.util.Stack;

public class QueueUsingStack{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x){/// have made push a bit costly
        if(s2.isEmpty()) // if s2 is empty push directly on s2
        {
            s2.push(x);
        }
        else{
            while(!s2.isEmpty()){ // if not put everthing into another stack
                s1.push(s2.pop());
            }
            s2.push(x);// add this item to s2
            while(!s1.isEmpty()){
                s2.push(s1.pop());// put everything bcak again to s2
            }
        }
    }
    public int pop(){
        return s2.pop();// since everything is in s2 directly pop from s2
    }
    public int peek(){
        return s2.peek(); // since everything is in s2 directly peek from s2
    }
    public boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();// if both of them are empty queue is empty
    }

    public static void main(String args[]){
        QueueUsingStack obj = new QueueUsingStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);

        System.out.println("Top element of queue: "+ obj.peek());
        while(!obj.isEmpty())
        {
            System.out.println("pop() "+obj.pop());
        }
    }
}