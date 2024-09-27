// Time Complexity : push -O(1), pop-O(1), peek-O(1) , empty-O(1)
// Space Complexity : O(n) where n is no. of element 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

//1:1 mapping 


class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop()); 
            }
        }
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop()); 
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return (in.isEmpty() && out.isEmpty());
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