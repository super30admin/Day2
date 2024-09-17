Time Complexity : linear time 


class MyQueue {

    Stack <Integer> stack1 = new Stack();
       Stack <Integer> stack2 = new Stack ();
   /** Initialize your data structure here. */
   public MyQueue() {
       
           
       
              
   }
   
   /** Push element x to the back of queue. */
   public void push(int x) {
       
       
       stack1.push(x);
       
       
   }
   
   /** Removes the element from in front of queue and returns that element. */
   public int pop() {
       
       
       if ( stack1.isEmpty() && stack2.isEmpty())
       {
           return 0;
       }
       
           if ( !stack2.isEmpty())
       {
           return stack2.pop();
       }
       
       else if ( !stack1.isEmpty() )
       {
           transferStack();
           return stack2.pop();
            }
       
      return 0;
       
   }
   
   /** Get the front element. */
   public int peek() {
       
       if ( stack1.isEmpty() && stack2.isEmpty()) { return 0;}
       else if  ( !stack2.isEmpty())
       {
          return  stack2.peek();
       }
       
       transferStack();
       return stack2.peek();
   
   }
   
   /** Returns whether the queue is empty. */
   public boolean empty() {
       
        if ( stack1.isEmpty() &&  stack2.isEmpty())
        { return true;}
       
       return false ; 

   }
   
   
   public void transferStack(){
       
         while ( !stack1.isEmpty())
           {
               stack2.push(stack1.pop());
           
           }
       
  
       
   }
   
//      private Stack <Integer> s1;
//     private Stack <Integer> s2;
      

}

/**
* Your MyQueue object will be instantiated and called as such:
* MyQueue obj = new MyQueue();
* obj.push(x);
* int param_2 = obj.pop();
* int param_3 = obj.peek();
* boolean param_4 = obj.empty();
*/