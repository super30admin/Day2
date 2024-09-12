import java.util.*;;

public class problem2 {
// Time Complexity : O(1)
// Space Complexity : O(1) for Average case than O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
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
        peek();
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
        return in.isEmpty() && out.isEmpty();   
    }

}
