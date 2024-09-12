
/*Time Complexity : O(1) Amortized O(1)
 Space Complexity :O(N)
Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this : No

*/
class MyQueue {
    Stack<Integer> in ;
    Stack<Integer> out;

    public MyQueue() {
        in =  new Stack<Integer>();
        out = new Stack<Integer>();
        
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek();
        return out.pop();
    }
    
    public int peek() {
        if(out.empty() == true ){
            while(! in.empty()){
                out.push(in.pop());
            }
        }
        return out.peek();      
    }
    
    public boolean empty() {
        if(in.empty() && out.empty()){
            return true;
        }else{
            return false;
        }
        
    }
}
