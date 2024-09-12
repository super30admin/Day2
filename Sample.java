import java.util.*;
//Problem-3 Implement Queue using Stack
// Time Complexity : push - O(1), isEmpty - O(1), pop - O(n), peek - O(n)
// Space Complexity : push - O(n), isEmpty - O(1), pop - O(1) or O(n), peek - O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : peek can be achieved in O(1) by maintaining a variable front. 




// Your code here along with comments explaining your approach

class MyQueue{

    //keep two stacks to perform operations
    Stack<Integer> stk;
    Stack<Integer> buffer;

    public MyQueue(){
        stk = new Stack<>();
        buffer = new Stack<>();
    }

    //push into stack
    public void push(int x){
        stk.push(x);
    }


    //To remove first inserted element - front of queue
    public int pop(){
        if(buffer.isEmpty()){
            while(!stk.isEmpty()){
                buffer.push(stk.pop());
            }
        }
        return buffer.pop();
    }


    //To get front element 
    public int peek(){
        if (buffer.isEmpty()){
            while(!stk.isEmpty()){
                buffer.push(stk.pop());
            }
        }
        return buffer.peek();
    }

    public boolean isEmpty(){
        return stk.isEmpty() && buffer.isEmpty();
    }


    public static void main(String[] args){
        MyQueue q1 = new MyQueue();
        q1.push(1);
        q1.push(2);
        q1.push(3);
        System.out.println(q1.pop());
        System.out.println(q1.peek());
        q1.push(4);
        System.out.println(q1.peek());
    }


}
