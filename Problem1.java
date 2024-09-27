import java.util.*;
public class Problem1 {
     /** Initialize your data structure here. */
     Stack<Integer> one;
     Stack<Integer> two;
     public Problem1() 
     {
         one = new Stack<Integer>();
         two = new Stack<Integer>();
     }
     
     /** Push element x to the back of queue. */
     public void push(int x) 
     {
         one.push(x);
     }
     
     /** Removes the element from in front of queue and returns that element. */
     public int pop() 
     {
         Integer x = 0;
         if(two.empty())
         {
             while(!one.empty())
             {
                 x =  one.pop();
                 two.push(x);
             }
             return two.pop().intValue();
         }
         return two.pop().intValue();
         
     }
     
     /** Get the front element. */
     public int peek() 
     {
        Integer x = 0;
         if(two.empty())
         {
             while(!one.empty())
             {
                 x =  one.pop();
                 two.push(x);
             }
             return two.peek().intValue();
         }
         return two.peek().intValue();
     }
     
     /** Returns whether the queue is empty. */
     public boolean empty() 
     {
         if(two.empty() && one.empty())
             return true;
         return false;
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
