// Operation:           push    pop     top     gtMin
// Time Complexity:     O(1)    O(1)    O(1)     O(1)
// Space Complexity:    O(n)    O(n)    O(n)     O(n)
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement in Brute force approach

package src;

import java.util.Stack;

public class QueueCreate
{
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        System.out.println("Popped element: "+ obj.pop());
        System.out.println("Popped element: "+ obj.peek());
        System.out.println("Stack Empty?? --> "+obj.empty());
        obj.push(2);
        obj.push(3);
        System.out.println("Popped element: "+ obj.peek());
        System.out.println("Stack Empty?? --> "+obj.empty());
        System.out.println("Popped element: "+ obj.pop());
        System.out.println("Popped element: "+ obj.peek());
    }
}


class MyQueue {

    static Stack<Integer> stk1 ;
    static Stack<Integer> stk2 ;

    public MyQueue() {
        stk1 = new Stack<>() ;                              // Stack 1 for pushing
        stk2 = new Stack<>() ;                              // Stack 2 for popping
    }

    public void push(int x) {
        stk1.push(x) ;                                      // Pushing elements directly in Stack 1
    }

    public int pop() {
        if(stk2.isEmpty())
        {
            while (!stk1.isEmpty())                           // Pushing all elements to Stack 2 from Stack 1
                stk2.push(stk1.pop());
        }
        return stk2.pop() ;
    }

    public int peek() {
        if(stk2.isEmpty())
        {
            while (!stk1.isEmpty())                           // Pushing all elements to Stack 2 from Stack 1
                stk2.push(stk1.pop());
        }
        return stk2.peek();
    }

    public boolean empty() {
        return (stk1.isEmpty() && stk2.isEmpty()) ;           // If both Stacks are empty then no element left
    }
}

// ****************************** Brute Force approach ******************************
//class MyQueue
//{
//    static Stack<Integer> stk1 ;
//    static Stack<Integer> stk2 ;
//
//    public MyQueue() {
//        stk1 = new Stack<>() ;
//        stk2 = new Stack<>() ;
//    }
//
//    public void push(int x) {
//        while(!stk1.isEmpty())
//        {
//            stk2.push(stk1.pop()) ;
//        }
//        stk1.push(x) ;
//        while(!stk2.isEmpty())
//        {
//            stk1.push(stk2.pop()) ;
//        }
//    }
//
//    public int pop() {
//        if(!stk1.isEmpty())
//        {
//            return stk1.pop() ;
//        }
//        return -1;
//    }
//
//    public int peek() {
//        if(!stk1.isEmpty())
//        {
//            return stk1.peek() ;
//        }
//        return -1;
//    }
//
//    public boolean empty() {
//        return stk1.isEmpty() ;
//    }
//}

