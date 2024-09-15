// Time Complexity :O(1) for push, O(1) for avg pop case and worst case O(n), O(1) for peek
// Space Complexity : O(n) creates an additonal stack. stack of size n 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class MyQueue {
  Stack <Integer> s1;
     Stack <Integer> s2;
    public MyQueue() {
    s1=new Stack<Integer>();
    s2=new Stack<Integer>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    public void convertPushToPop(){
          int size=s1.size();
        for(int i=0;i<size;i++){
            int top=s1.pop();
            s2.push(top);
    }
    }
    public int pop() {
        if(s2.isEmpty()){
           convertPushToPop();
        }
        
        return s2.pop(); 
        
    }
    
    public int peek() {
         if(s2.isEmpty()){
           convertPushToPop();
        }
        
        return s2.peek(); 
        
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    
    public static void main(String args[]) {
    	 MyQueue obj = new MyQueue();
    	  obj.push(2);
    	  obj.push(3);
    	  obj.push(1);
    	 int param_2 = obj.pop();
    	 int param_3 = obj.peek();
    	 boolean param_4 = obj.empty();
    	 System.out.print(param_2);
    	 System.out.print(param_3);
    	 System.out.print(param_4);
    }
}



