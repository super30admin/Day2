//Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

// Here 2 stacks were taken in order to implement queue FIFO data structure working, in push operation elements are added in stack1 and in pop operation elements are 
// removed from stack1 and added in stack 2 and last element of stack2 is popped out or peeked    

import java.util.Stack;

public class problem1 {
    class MyQueue{
        Stack<Integer> inSt;
        Stack<Integer> outSt;
        public MyQueue(){
            inSt= new Stack<>();
            outSt= new Stack<>();
        }
        public void push(int x){
            inSt.push(x);
        }
        public int pop(){
            if (outSt.isEmpty())
            {
                while (!inSt.isEmpty())
                {
                    outSt.push(inSt.pop());
                }
            }
            return outSt.pop();
        }
        public int peek(){
            if (outSt.isEmpty())
            {
                while (!inSt.isEmpty())
                {
                    outSt.push(inSt.pop());
                }
            }
            return outSt.peek();
        }
        public boolean isEmpty(){
            return inSt.isEmpty() && outSt.isEmpty();
        }
    }
}
