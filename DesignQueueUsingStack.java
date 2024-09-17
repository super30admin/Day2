// Time Complexity :

// Pop and Peek : Average time complexity  O(1) , but worst time complexity : O(n) as we push all elements from instack to outstack
// Empty : O(1)
// Push : O(1)

// Space Complexity : O(n) as we are using two stacks

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : None

//Solution:
import java.util.*;
class DesingQueueUsingStack {

    static Stack<Integer> in = new Stack<>();
    static Stack<Integer> out = new Stack<>();


    /** Push element x to the back of queue. */
    public static void push(int x) {
        in.push(x); // Push elements into inStack
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        /* if outStack is empty, push all elements of inStack into OutStack*/
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }

        }
        //Edge case to check if outstack is empty and we try to pop from it
        if(out.isEmpty()){
            System.out.println("Queue is empty");
            return 0;
        }
        //Pop always from the outStack
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        /* if outStack is empty, push all elements of inStack into OutStack*/
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }

        }
        //Edge case to check if outstack is empty and we try to peek from it
        if(out.isEmpty()){
            System.out.println("Queue is empty");
            return 0;
        }
        //Peek always from outStack
        return out.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        //Checks if both stacks are empty as elements are distributed into both stacks
        return in.isEmpty()&&out.isEmpty();
    }


}

class Main{
    public static void main(String args[]){
        DesingQueueUsingStack obj = new DesingQueueUsingStack();
        DesingQueueUsingStack.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
}

