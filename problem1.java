//Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)

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
