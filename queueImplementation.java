// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

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

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


MY APPROACH ->

Here main thing is we need first in first out FIFO and we are using stack which is FILO

1. So using two stacks first stack will be IN and other will be OUT whenever push is there we will directly push in IN 
2. Whenever POP is there we will check OUT stack if it is not empty directly POP peek element as it is already inverted if empty copy ALL elements in OUT 
3. Now POP will occur each time elements in OUT will be inverted So FIRST OUT order will be right and if empty copy IN and the POP
4. Giving peek is same as POP as needed First IN element so we will perform above operation only but we will not POP we will PEEK OUT's element and return.
