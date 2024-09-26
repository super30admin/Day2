import java.util.*;
class MyQueue {
    int size=0;
        Stack<Integer> s1= new Stack<>();
            Stack <Integer> s2= new Stack<>();
       
        public MyQueue() {
         
          
        
        }
        
        public void push(int x) {
        
            s1.push(x); 
        size++;
        
        }
        
        public int pop() {
            
           if( s2.isEmpty()){
                
                while(!s1.isEmpty()){
                    
                    s2.push(s1.pop());
                }
            }
            
            return s2.pop();
        }
        
        
        public int peek() {
            
            if( s2.isEmpty()){
                
                while(!s1.isEmpty()){
                    
                    s2.push(s1.pop());
                }
            }
            
            return s2.peek();
        }
        
        public boolean empty() {
           if(s1.isEmpty()&&s2.isEmpty()){return true;}else{return false;} 
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