// Time Complexity : O(1) for push and isEmpty. 
//                  For pop and peek, time complexity for some elements will be O(N) so it is amortized O(1)
// Space Complexity : O(N) where N is size of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class MyQueueUsingStack {

    Stack<Integer> stack1; // push stack
    Stack<Integer> stack2; // pop and peek stack

    public MyQueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {

        if(empty()){
            System.out.println("No data to pop");
            return Integer.MIN_VALUE;
        }

        if(stack2.isEmpty()){
            //transfer all elements to stack2
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    public int peek() {

        if(empty()){
            System.out.println("No data to peek");
            return Integer.MIN_VALUE;
        }

        if(stack2.isEmpty()){
            //transfer all elements to stack2
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}

public class QueueUsingStack{
    public static void main(String args[]){
        MyQueueUsingStack myQueueUsingStack = new MyQueueUsingStack();

        System.out.println("peeked: "+ myQueueUsingStack.peek());
        myQueueUsingStack.push(2);
        myQueueUsingStack.push(3);
        myQueueUsingStack.push(4);
        myQueueUsingStack.push(5);

        System.out.println("poped: "+ myQueueUsingStack.pop());
        System.out.println("peeked: "+ myQueueUsingStack.peek());

        myQueueUsingStack.push(6);
        myQueueUsingStack.push(7);

        System.out.println("peeked: "+ myQueueUsingStack.peek());
        System.out.println("poped: "+ myQueueUsingStack.pop());
    }
}

