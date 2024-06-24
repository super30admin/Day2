// Time complexity: O(1)
// Space Complexity: O(1)


import java.util.Stack;

class MyQueue {
        private Stack<Integer> in;
        private Stack<Integer> out;
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

    public static void main(String args[]){
           MyQueue obj = new MyQueue();
           obj.push(2);
           obj.push(3);
           obj.push(4);
           int param_2 = obj.pop();
           System.out.println(param_2);
           int param_3 = obj.peek();
           System.out.println(param_3);
           boolean param_4 = obj.empty();
           System.out.println(param_4);
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