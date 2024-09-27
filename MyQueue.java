
import java.util.*;

class MyQueue {

    Stack<Integer> push_stack; 
    Stack<Integer> pop_stack; 
   
   /** Initialize your data structure here. */
   public MyQueue() {
     push_stack=new Stack<>();
       pop_stack=new Stack<>();
   }
   
   /** Push element x to the back of queue. */
   public void push(int x) {
      push_stack.push(x); 
   }
   
   /** Removes the element from in front of queue and returns that element. */
   public int pop() {
       peek();
       return pop_stack.pop();
   }
   
   /** Get the front element. */
   public int peek() {
       if(pop_stack.empty()){
           while(!push_stack.empty()){
               pop_stack.push(push_stack.pop());
           }
       }
       return pop_stack.peek();
   }
   
   /** Returns whether the queue is empty. */
   public boolean empty() {
       return push_stack.empty() && pop_stack.empty();
   }

   public static void main(String args[]){
    MyQueue obj = new MyQueue();
    obj.push(13);
    obj.push(2);
    obj.push(45);
    obj.push(28);
    System.out.println("popped element= "+ obj.pop());
    System.out.println("top element="+obj.peek());
    System.out.println("check is queue is empty="+obj.empty());

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