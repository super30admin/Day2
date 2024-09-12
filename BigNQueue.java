import java.util.*;

public class BigNQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int start;
    /** Implementing queue using two stacks**/
    void push(int n){
        if(s1.isEmpty())
            start = n;
        while(!s1.isEmpty())
            s2.push(s1.pop());
        s1.push(n);
        while(!s2.isEmpty())
            s1.push(s2.pop());
    }

    int pop(){
        int k = s1.pop();
        if(!s1.isEmpty())
            start = s1.peek();
        return k;
    }

    int peek(){
        return start;
    }

    boolean empty(){
        return s1.isEmpty();
    }

    public static void main(String[] args){
        BigNQueue queue = new BigNQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());

    }
}
