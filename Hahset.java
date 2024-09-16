//Time complexity : push : 0(n) , pop :O(1); peek : O(1); empty :o(1)
//Space : push :o(n) , pop :O(1) 

class MyQueue {

    
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;
    public MyQueue() {
        s1=new Stack<>();
        s2 = new Stack<>();
       
        
    }
    
    public void push(int x) {
          
        while(!s1.isEmpty())
        {
            
            s2.push(s1.pop());
            
        }
        s1.push(x);
        while (!s2.isEmpty())
               {
                   
                   s1.push(s2.pop());
               }
        
        front= s1.peek();
        
        
    }
    
    public int pop() {
        
        int z = s1.pop();
        
        if(!s1.empty())
        front = s1.peek();
        return z;
        
    }
    
    public int peek() {
        
        return front;
        
    }
    
    public boolean empty() {
        if(s1.isEmpty())
           {
               return true;
           }
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