//Space Complexity is : O(n)
//Time Complexity is : O(n)
class MyQueue {
    private Stack<Integer> S1;
    private Stack<Integer> S2;
    public MyQueue() {
        S1= new Stack<Integer>();
        S2= new Stack<Integer>();
        
    }
    
    public void push(int x) {
        this.S1.push(x);
        
    }
    
    public int pop() {
        if(this.S2.empty())
        {
            while(!this.S1.empty())
            {
                int temp=S1.pop();
                S2.push(temp);

            }
            return S2.pop();
        }
        else
            return S2.pop();
        
        
    }
    
    public int peek() {
        if(S2.empty())
        {
            while(!S1.empty())
            {
                int temp=S1.pop();
                S2.push(temp);

            }
            return S2.peek();
        }
        else
            return S2.peek();
        
        
    }
    
    public boolean empty() {
        if(S1.empty()&&S2.empty())
        {
            return true;
        }
        return false;
    }
}